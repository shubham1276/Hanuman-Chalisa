package com.example.ui.screens

import android.net.Uri
import androidx.activity.compose.BackHandler
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Audiotrack
import androidx.compose.material.icons.filled.FastForward
import androidx.compose.material.icons.filled.FastRewind
import androidx.compose.material.icons.filled.GraphicEq
import androidx.compose.material.icons.filled.NotificationsActive
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.RecordVoiceOver
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.UploadFile
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
import com.example.audio.AudioPlayerManager
import com.example.audio.MaleVoiceTone
import com.example.data.AppPreferences
import com.example.data.ChalisaData
import com.example.ui.theme.SacredGold
import com.example.ui.theme.SacredGoldLight
import com.example.ui.theme.SaffronPrimary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AudioPlayerScreen(
    audioManager: AudioPlayerManager,
    preferences: AppPreferences,
    onBack: () -> Unit
) {
    BackHandler { onBack() }

    val currentVerse = ChalisaData.getVerse(audioManager.currentVerseIndex)

    // Audio file picker launcher for custom recording replacement
    val audioPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        if (uri != null) {
            audioManager.loadCustomAudio(uri, "Custom User Recording")
        }
    }

    // Subtle breathing aura animation when playing
    val infiniteTransition = rememberInfiniteTransition(label = "pulse")
    val auraScale by infiniteTransition.animateFloat(
        initialValue = 1.0f,
        targetValue = if (audioManager.isPlaying) 1.08f else 1.0f,
        animationSpec = infiniteRepeatable(
            animation = tween(1200, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "auraScale"
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "चालीसा श्रवण (Audio)",
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = onBack,
                        modifier = Modifier.testTag("audio_back_btn")
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                },
                actions = {
                    IconButton(
                        onClick = { audioManager.playBellTone() },
                        modifier = Modifier.testTag("audio_bell_btn")
                    ) {
                        Icon(
                            imageVector = Icons.Default.NotificationsActive,
                            contentDescription = "Ring Temple Bell",
                            tint = SacredGold
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.background)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 20.dp, vertical = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(8.dp))

            // Animated Sacred Aura Artwork
            Box(
                modifier = Modifier
                    .size(160.dp)
                    .scale(auraScale)
                    .shadow(16.dp, CircleShape)
                    .clip(CircleShape)
                    .border(4.dp, SacredGold, CircleShape)
                    .background(
                        Brush.radialGradient(
                            listOf(
                                SacredGold.copy(alpha = 0.4f),
                                SaffronPrimary.copy(alpha = 0.85f)
                            )
                        )
                    ),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img_hanuman_hero),
                    contentDescription = "Lord Hanuman meditating",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.height(18.dp))

            // Highlighted Active Chanted Verse Card (Requirement 4: "Highlight the current verse while audio plays")
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .widthIn(max = 600.dp)
                    .shadow(6.dp, RoundedCornerShape(20.dp))
                    .testTag("audio_active_verse_card"),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                ),
                border = androidx.compose.foundation.BorderStroke(2.dp, SaffronPrimary)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(18.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.GraphicEq,
                            contentDescription = "Now chanting",
                            tint = SaffronPrimary,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "${currentVerse.numberTitleHindi} (${audioManager.currentVerseIndex + 1} / ${ChalisaData.verses.size})",
                            style = MaterialTheme.typography.labelLarge.copy(
                                fontWeight = FontWeight.Bold,
                                color = SaffronPrimary
                            )
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = currentVerse.hindiText,
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontSize = 24.sp,
                            lineHeight = 34.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.Serif
                        ),
                        color = MaterialTheme.colorScheme.primary,
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = currentVerse.englishTranslit,
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Medium
                        ),
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = currentVerse.hindiMeaning,
                        style = MaterialTheme.typography.bodySmall.copy(
                            fontSize = 14.sp
                        ),
                        color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.8f),
                        textAlign = TextAlign.Center
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Progress Slider
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .widthIn(max = 600.dp)
            ) {
                val progressFraction = (audioManager.currentVerseIndex.toFloat() / ChalisaData.verses.lastIndex.coerceAtLeast(1))
                    .coerceIn(0f, 1f)

                Slider(
                    value = progressFraction,
                    onValueChange = { fraction ->
                        val targetVerse = (fraction * ChalisaData.verses.lastIndex).toInt()
                        audioManager.seekToVerse(targetVerse)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("audio_progress_slider"),
                    colors = SliderDefaults.colors(
                        thumbColor = SaffronPrimary,
                        activeTrackColor = SaffronPrimary,
                        inactiveTrackColor = SacredGold.copy(alpha = 0.25f)
                    )
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "${audioManager.currentVerseIndex + 1} / ${ChalisaData.verses.size}",
                        style = MaterialTheme.typography.labelMedium.copy(color = MaterialTheme.colorScheme.onSurfaceVariant)
                    )
                    Text(
                        text = if (audioManager.isCustomAudioLoaded) audioManager.customAudioName ?: "Custom Recording" else "दिव्य पाठ (Divine Recitation)",
                        style = MaterialTheme.typography.labelMedium.copy(
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.SemiBold
                        )
                    )
                }
            }

            Spacer(modifier = Modifier.height(18.dp))

            // BIG PLAYER CONTROLS (Requirement 4: "with big buttons")
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .widthIn(max = 600.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Previous Verse Button (56dp)
                Surface(
                    onClick = { audioManager.previousVerse() },
                    shape = CircleShape,
                    color = MaterialTheme.colorScheme.surfaceVariant,
                    modifier = Modifier
                        .size(56.dp)
                        .testTag("audio_btn_prev"),
                    border = androidx.compose.foundation.BorderStroke(1.dp, SacredGold.copy(alpha = 0.5f))
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Icon(
                            imageVector = Icons.Default.FastRewind,
                            contentDescription = "Previous Verse",
                            modifier = Modifier.size(30.dp),
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                }

                Spacer(modifier = Modifier.width(28.dp))

                // GIANT PLAY / PAUSE BUTTON (76dp)
                Surface(
                    onClick = { audioManager.togglePlayPause() },
                    shape = CircleShape,
                    color = SaffronPrimary,
                    modifier = Modifier
                        .size(76.dp)
                        .shadow(10.dp, CircleShape)
                        .testTag("audio_btn_play_pause"),
                    border = androidx.compose.foundation.BorderStroke(2.dp, SacredGoldLight)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Icon(
                            imageVector = if (audioManager.isPlaying) Icons.Default.Pause else Icons.Default.PlayArrow,
                            contentDescription = if (audioManager.isPlaying) "Pause" else "Play",
                            modifier = Modifier.size(44.dp),
                            tint = Color.White
                        )
                    }
                }

                Spacer(modifier = Modifier.width(28.dp))

                // Next Verse Button (56dp)
                Surface(
                    onClick = { audioManager.nextVerse() },
                    shape = CircleShape,
                    color = MaterialTheme.colorScheme.surfaceVariant,
                    modifier = Modifier
                        .size(56.dp)
                        .testTag("audio_btn_next"),
                    border = androidx.compose.foundation.BorderStroke(1.dp, SacredGold.copy(alpha = 0.5f))
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Icon(
                            imageVector = Icons.Default.FastForward,
                            contentDescription = "Next Verse",
                            modifier = Modifier.size(30.dp),
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Strong Male Chanting Voice Selector (Requirement: Strong male voice)
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .widthIn(max = 600.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.RecordVoiceOver,
                        contentDescription = "Voice Tone",
                        tint = SaffronPrimary,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "भक्तिमय पुरुष स्वर (Strong Male Chanting):",
                        style = MaterialTheme.typography.labelMedium.copy(
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    MaleVoiceTone.entries.forEach { tone ->
                        val isSelected = audioManager.selectedVoiceTone == tone
                        FilterChip(
                            selected = isSelected,
                            onClick = { audioManager.setVoiceTone(tone) },
                            label = {
                                Text(
                                    text = when (tone) {
                                        MaleVoiceTone.STRONG_BARITONE -> "गंभीर स्वर (Baritone)"
                                        MaleVoiceTone.VEDIC_BASS -> "वैदिक स्वर (Deep Bass)"
                                        MaleVoiceTone.CLEAR_MALE -> "स्पष्ट स्वर (Clear Male)"
                                    }
                                )
                            },
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = MaterialTheme.colorScheme.primaryContainer
                            )
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(18.dp))

            // Speech / Recitation Speed Selector
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .widthIn(max = 600.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "पाठ गति (Chanting Speed):",
                    style = MaterialTheme.typography.labelMedium.copy(
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    FilterChip(
                        selected = audioManager.playbackSpeed == 0.8f,
                        onClick = { audioManager.setSpeed(0.8f) },
                        label = { Text("0.8x (धीमी - Slow)") },
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = MaterialTheme.colorScheme.primaryContainer
                        )
                    )
                    FilterChip(
                        selected = audioManager.playbackSpeed == 0.95f || audioManager.playbackSpeed == 1.0f,
                        onClick = { audioManager.setSpeed(0.95f) },
                        label = { Text("1.0x (सामान्य - Normal)") },
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = MaterialTheme.colorScheme.primaryContainer
                        )
                    )
                    FilterChip(
                        selected = audioManager.playbackSpeed == 1.2f,
                        onClick = { audioManager.setSpeed(1.2f) },
                        label = { Text("1.2x (तीव्र - Fast)") },
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = MaterialTheme.colorScheme.primaryContainer
                        )
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // CUSTOM RECORDING PLACEHOLDER (Requirement 4: "Add a placeholder for an audio file that I can replace with my own recording")
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .widthIn(max = 600.dp),
                shape = RoundedCornerShape(18.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.45f)
                ),
                border = androidx.compose.foundation.BorderStroke(1.dp, SacredGold.copy(alpha = 0.35f))
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Audiotrack,
                            contentDescription = "Audio Source",
                            tint = SaffronPrimary,
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Column {
                            Text(
                                text = "ऑडियो स्रोत (Audio Recording Slot)",
                                style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold)
                            )
                            Text(
                                text = if (audioManager.isCustomAudioLoaded)
                                    "Loaded: ${audioManager.customAudioName}"
                                else
                                    "Built-in Chanting Active (TTS/Synthesis)",
                                style = MaterialTheme.typography.bodySmall.copy(
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Button(
                            onClick = { audioPickerLauncher.launch("audio/*") },
                            modifier = Modifier
                                .weight(1f)
                                .height(48.dp)
                                .testTag("btn_replace_audio"),
                            shape = RoundedCornerShape(12.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer,
                                contentColor = MaterialTheme.colorScheme.primary
                            )
                        ) {
                            Icon(
                                imageVector = Icons.Default.UploadFile,
                                contentDescription = "Pick audio file",
                                modifier = Modifier.size(18.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = "अपना ऑडियो जोड़ें",
                                style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold)
                            )
                        }

                        if (audioManager.isCustomAudioLoaded) {
                            OutlinedButton(
                                onClick = { audioManager.resetToDefaultRecitation() },
                                modifier = Modifier.height(48.dp),
                                shape = RoundedCornerShape(12.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Refresh,
                                    contentDescription = "Reset audio",
                                    modifier = Modifier.size(18.dp)
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Text("Reset")
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}
