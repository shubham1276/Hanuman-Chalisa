package com.example.audio

import android.content.Context
import android.media.AudioAttributes
import android.media.AudioFormat
import android.media.AudioTrack
import android.media.MediaPlayer
import android.net.Uri
import android.os.Build
import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.data.ChalisaData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import java.util.Locale
import kotlin.math.sin

enum class MaleVoiceTone(val title: String, val subtitle: String, val pitch: Float) {
    STRONG_BARITONE("गंभीर पुरुष स्वर (Strong Male Baritone)", "Deep & Devotional", 0.72f),
    VEDIC_BASS("वैदिक गुरु स्वर (Deep Vedic Bass)", "Authoritative Chanting", 0.65f),
    CLEAR_MALE("स्पष्ट पुरुष स्वर (Clear Resonant Male)", "Natural & Steady", 0.78f)
}

class AudioPlayerManager(private val context: Context) {
    private val scope = CoroutineScope(Dispatchers.Main)

    var isPlaying by mutableStateOf(false)
        private set

    var currentVerseIndex by mutableIntStateOf(0)
        private set

    var playbackSpeed by mutableFloatStateOf(0.95f)
        private set

    var selectedVoiceTone by mutableStateOf(MaleVoiceTone.STRONG_BARITONE)
        private set

    var isCustomAudioLoaded by mutableStateOf(false)
        private set

    var customAudioName by mutableStateOf<String?>(null)
        private set

    var currentPositionMs by mutableLongStateOf(0L)
        private set

    var totalDurationMs by mutableLongStateOf(43 * 8000L) // estimated 43 verses * 8s
        private set

    private var tts: TextToSpeech? = null
    private var isTtsReady = false
    private var mediaPlayer: MediaPlayer? = null
    private var progressTrackingJob: Job? = null

    init {
        initTts()
    }

    private fun initTts() {
        tts = TextToSpeech(context) { status ->
            if (status == TextToSpeech.SUCCESS) {
                applyMaleVoiceSettings()

                tts?.setOnUtteranceProgressListener(object : UtteranceProgressListener() {
                    override fun onStart(utteranceId: String?) {
                        scope.launch {
                            isPlaying = true
                        }
                    }

                    override fun onDone(utteranceId: String?) {
                        scope.launch {
                            val nextIndex = currentVerseIndex + 1
                            if (nextIndex < ChalisaData.verses.size && isPlaying) {
                                currentVerseIndex = nextIndex
                                playVerse(nextIndex)
                            } else {
                                isPlaying = false
                                currentVerseIndex = 0
                            }
                        }
                    }

                    override fun onError(utteranceId: String?, errorCode: Int) {
                        scope.launch {
                            isPlaying = false
                        }
                    }

                    @Deprecated("Deprecated in Java", ReplaceWith("onError(utteranceId, errorCode)"))
                    override fun onError(utteranceId: String?) {
                        scope.launch {
                            isPlaying = false
                        }
                    }
                })
                isTtsReady = true
            }
        }
    }

    private fun applyMaleVoiceSettings() {
        try {
            val hiLocale = Locale("hi", "IN")
            val langResult = tts?.setLanguage(hiLocale)
            if (langResult == TextToSpeech.LANG_MISSING_DATA || langResult == TextToSpeech.LANG_NOT_SUPPORTED) {
                tts?.language = Locale.ENGLISH
            }

            // Set deep, resonant masculine pitch for authentic male chanting
            tts?.setPitch(selectedVoiceTone.pitch)
            tts?.setSpeechRate(playbackSpeed)

            // Specifically prioritize male voice from system voices if available
            val availableVoices = tts?.voices
            if (!availableVoices.isNullOrEmpty()) {
                val maleVoice = availableVoices.firstOrNull { voice ->
                    val vName = voice.name.lowercase()
                    val isHindi = voice.locale.language == "hi"
                    val isMale = vName.contains("male") || vName.contains("-m-") ||
                            vName.contains("man") || vName.contains("hie") ||
                            vName.contains("hia")
                    val hasMaleFeature = voice.features?.any { it.contains("male", ignoreCase = true) } == true
                    isHindi && (isMale || hasMaleFeature)
                } ?: availableVoices.firstOrNull { voice ->
                    voice.locale.language == "hi" && !voice.name.lowercase().contains("female")
                } ?: availableVoices.firstOrNull { voice ->
                    voice.locale.country.equals("IN", ignoreCase = true) &&
                            (voice.name.lowercase().contains("male") || voice.name.lowercase().contains("-m-"))
                }

                if (maleVoice != null) {
                    tts?.voice = maleVoice
                }
            }
        } catch (e: Exception) {
            tts?.setPitch(selectedVoiceTone.pitch)
        }
    }

    fun setVoiceTone(tone: MaleVoiceTone) {
        selectedVoiceTone = tone
        applyMaleVoiceSettings()
        if (isPlaying && !isCustomAudioLoaded) {
            tts?.stop()
            playVerse(currentVerseIndex)
        }
    }

    fun play() {
        if (isCustomAudioLoaded && mediaPlayer != null) {
            mediaPlayer?.start()
            isPlaying = true
            startProgressTracking()
        } else {
            isPlaying = true
            playVerse(currentVerseIndex)
            startProgressTracking()
        }
    }

    fun pause() {
        isPlaying = false
        if (isCustomAudioLoaded) {
            mediaPlayer?.pause()
        } else {
            tts?.stop()
        }
        progressTrackingJob?.cancel()
    }

    fun togglePlayPause() {
        if (isPlaying) {
            pause()
        } else {
            play()
        }
    }

    fun seekToVerse(index: Int) {
        val safeIndex = index.coerceIn(0, ChalisaData.verses.lastIndex)
        currentVerseIndex = safeIndex
        currentPositionMs = (safeIndex.toLong() * totalDurationMs) / ChalisaData.verses.size

        if (isCustomAudioLoaded && mediaPlayer != null) {
            val targetMs = (safeIndex.toFloat() / ChalisaData.verses.size * (mediaPlayer?.duration ?: 1)).toInt()
            mediaPlayer?.seekTo(targetMs)
        }

        if (isPlaying) {
            if (!isCustomAudioLoaded) {
                tts?.stop()
                playVerse(safeIndex)
            }
        }
    }

    fun nextVerse() {
        if (currentVerseIndex < ChalisaData.verses.lastIndex) {
            seekToVerse(currentVerseIndex + 1)
        }
    }

    fun previousVerse() {
        if (currentVerseIndex > 0) {
            seekToVerse(currentVerseIndex - 1)
        }
    }

    fun setSpeed(speed: Float) {
        playbackSpeed = speed
        tts?.setSpeechRate(speed)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && isCustomAudioLoaded) {
            try {
                mediaPlayer?.playbackParams = mediaPlayer?.playbackParams?.setSpeed(speed) ?: return
            } catch (e: Exception) {
                // Ignore if not supported on custom audio
            }
        }
    }

    private fun playVerse(index: Int) {
        if (!isTtsReady) return
        applyMaleVoiceSettings()
        val verse = ChalisaData.getVerse(index)
        val textToSpeak = verse.hindiText.replace("॥", "।")
        val utteranceId = "verse_$index"

        val params = android.os.Bundle()
        params.putString(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, utteranceId)
        tts?.speak(textToSpeak, TextToSpeech.QUEUE_FLUSH, params, utteranceId)
    }

    private fun startProgressTracking() {
        progressTrackingJob?.cancel()
        progressTrackingJob = scope.launch {
            while (isActive && isPlaying) {
                if (isCustomAudioLoaded && mediaPlayer != null) {
                    val pos = mediaPlayer?.currentPosition?.toLong() ?: 0L
                    val dur = mediaPlayer?.duration?.toLong() ?: 1L
                    currentPositionMs = pos
                    totalDurationMs = dur
                    val computedVerse = ((pos.toFloat() / dur.coerceAtLeast(1)) * ChalisaData.verses.size).toInt()
                    currentVerseIndex = computedVerse.coerceIn(0, ChalisaData.verses.lastIndex)
                } else {
                    currentPositionMs = (currentVerseIndex.toLong() * totalDurationMs) / ChalisaData.verses.size
                }
                delay(300)
            }
        }
    }

    fun loadCustomAudio(uri: Uri, displayName: String = "Custom Recording") {
        try {
            pause()
            mediaPlayer?.release()
            mediaPlayer = MediaPlayer().apply {
                setDataSource(context, uri)
                prepare()
            }
            totalDurationMs = mediaPlayer?.duration?.toLong() ?: (43 * 8000L)
            isCustomAudioLoaded = true
            customAudioName = displayName
            currentVerseIndex = 0
            currentPositionMs = 0L
        } catch (e: Exception) {
            // Failed to load custom audio, fallback to TTS
            isCustomAudioLoaded = false
            customAudioName = null
        }
    }

    fun resetToDefaultRecitation() {
        pause()
        mediaPlayer?.release()
        mediaPlayer = null
        isCustomAudioLoaded = false
        customAudioName = null
        totalDurationMs = 43 * 8000L
        currentPositionMs = 0L
        currentVerseIndex = 0
    }

    fun playBellTone() {
        scope.launch(Dispatchers.Default) {
            try {
                // Generate a gentle 528 Hz sacred resonant bell chime
                val sampleRate = 22050
                val durationSec = 0.6
                val numSamples = (durationSec * sampleRate).toInt()
                val samples = ShortArray(numSamples)
                val freq = 528.0 // Solfeggio frequency / sacred chime

                for (i in 0 until numSamples) {
                    val t = i.toDouble() / sampleRate
                    // exponential decay envelope
                    val envelope = Math.exp(-4.5 * t)
                    val value = (sin(2.0 * Math.PI * freq * t) * envelope * 0.45 * Short.MAX_VALUE).toInt()
                    samples[i] = value.toShort()
                }

                val audioTrack = AudioTrack.Builder()
                    .setAudioAttributes(
                        AudioAttributes.Builder()
                            .setUsage(AudioAttributes.USAGE_MEDIA)
                            .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                            .build()
                    )
                    .setAudioFormat(
                        AudioFormat.Builder()
                            .setEncoding(AudioFormat.ENCODING_PCM_16BIT)
                            .setSampleRate(sampleRate)
                            .setChannelMask(AudioFormat.CHANNEL_OUT_MONO)
                            .build()
                    )
                    .setBufferSizeInBytes(samples.size * 2)
                    .setTransferMode(AudioTrack.MODE_STATIC)
                    .build()

                audioTrack.write(samples, 0, samples.size)
                audioTrack.play()
                delay((durationSec * 1000).toLong())
                audioTrack.release()
            } catch (e: Exception) {
                // Ignore audio track generation exception
            }
        }
    }

    fun release() {
        tts?.stop()
        tts?.shutdown()
        mediaPlayer?.release()
        mediaPlayer = null
        progressTrackingJob?.cancel()
    }
}
