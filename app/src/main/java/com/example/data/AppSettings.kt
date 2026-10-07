package com.example.data

import android.content.Context
import android.content.SharedPreferences
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

enum class TextScale(val title: String, val scaleFactor: Float, val sampleText: String) {
    SMALL("Small (छोटा)", 0.88f, "श्रीगुरु चरन सरोज रज"),
    MEDIUM("Medium (मध्यम)", 1.0f, "श्रीगुरु चरन सरोज रज"),
    LARGE("Large (बड़ा)", 1.25f, "श्रीगुरु चरन सरोज रज"),
    EXTRA_LARGE("Extra Large (अति बड़ा - बुजुर्गों हेतु)", 1.55f, "श्रीगुरु चरन सरोज रज")
}

enum class LanguageOption(val title: String, val subtitle: String) {
    HINDI("हिन्दी (Devanagari)", "Original Sacred Text"),
    ENGLISH("English", "Phonetic Roman Script"),
    GUJARATI("ગુજરાતી (Gujarati)", "ગુજરાતી લિપ્યંતરણ"),
    MARATHI("मराठी (Marathi)", "मराठी भावार्थ")
}

enum class AppThemeMode(val title: String, val subtitle: String) {
    LIGHT("सवेरा (Devotional Light)", "Saffron, Cream & Gold"),
    SOFT_DARK("संध्या (Soft Night)", "Warm Midnight & Amber"),
    SYSTEM("सिस्टम (System Default)", "Follow Device Theme")
}

class AppPreferences(context: Context) {
    private val prefs: SharedPreferences =
        context.getSharedPreferences("hanuman_chalisa_prefs", Context.MODE_PRIVATE)

    var textScale: TextScale by mutableStateOf(
        try {
            TextScale.valueOf(prefs.getString(KEY_TEXT_SCALE, TextScale.MEDIUM.name) ?: TextScale.MEDIUM.name)
        } catch (e: Exception) {
            TextScale.MEDIUM
        }
    )

    var language: LanguageOption by mutableStateOf(
        try {
            LanguageOption.valueOf(prefs.getString(KEY_LANGUAGE, LanguageOption.HINDI.name) ?: LanguageOption.HINDI.name)
        } catch (e: Exception) {
            LanguageOption.HINDI
        }
    )

    var themeMode: AppThemeMode by mutableStateOf(
        try {
            AppThemeMode.valueOf(prefs.getString(KEY_THEME_MODE, AppThemeMode.LIGHT.name) ?: AppThemeMode.LIGHT.name)
        } catch (e: Exception) {
            AppThemeMode.LIGHT
        }
    )

    var showDevanagari: Boolean by mutableStateOf(prefs.getBoolean(KEY_SHOW_DEVANAGARI, true))
    var showTransliteration: Boolean by mutableStateOf(prefs.getBoolean(KEY_SHOW_TRANSLIT, true))
    var showHindiMeaning: Boolean by mutableStateOf(prefs.getBoolean(KEY_SHOW_HINDI_MEANING, true))
    var showEnglishMeaning: Boolean by mutableStateOf(prefs.getBoolean(KEY_SHOW_ENGLISH_MEANING, true))
    var lastReadVerseIndex: Int by mutableIntStateOf(prefs.getInt(KEY_LAST_READ_VERSE, 0))

    // Jaap counter persistent preferences
    var jaapCount: Int by mutableIntStateOf(prefs.getInt(KEY_JAAP_COUNT, 0))
    var jaapTarget: Int by mutableIntStateOf(prefs.getInt(KEY_JAAP_TARGET, 108))
    var jaapMalasCompleted: Int by mutableIntStateOf(prefs.getInt(KEY_JAAP_MALAS_COMPLETED, 0))
    var jaapTotalCount: Int by mutableIntStateOf(prefs.getInt(KEY_JAAP_TOTAL_COUNT, 0))
    var jaapVibrate: Boolean by mutableStateOf(prefs.getBoolean(KEY_JAAP_VIBRATE, true))
    var jaapSound: Boolean by mutableStateOf(prefs.getBoolean(KEY_JAAP_SOUND, true))

    fun updateTextScale(scale: TextScale) {
        textScale = scale
        prefs.edit().putString(KEY_TEXT_SCALE, scale.name).apply()
    }

    fun updateLanguage(lang: LanguageOption) {
        language = lang
        prefs.edit().putString(KEY_LANGUAGE, lang.name).apply()
    }

    fun updateThemeMode(mode: AppThemeMode) {
        themeMode = mode
        prefs.edit().putString(KEY_THEME_MODE, mode.name).apply()
    }

    fun toggleDevanagari(enabled: Boolean) {
        showDevanagari = enabled
        prefs.edit().putBoolean(KEY_SHOW_DEVANAGARI, enabled).apply()
    }

    fun toggleTransliteration(enabled: Boolean) {
        showTransliteration = enabled
        prefs.edit().putBoolean(KEY_SHOW_TRANSLIT, enabled).apply()
    }

    fun toggleHindiMeaning(enabled: Boolean) {
        showHindiMeaning = enabled
        prefs.edit().putBoolean(KEY_SHOW_HINDI_MEANING, enabled).apply()
    }

    fun toggleEnglishMeaning(enabled: Boolean) {
        showEnglishMeaning = enabled
        prefs.edit().putBoolean(KEY_SHOW_ENGLISH_MEANING, enabled).apply()
    }

    fun saveLastReadVerse(index: Int) {
        lastReadVerseIndex = index.coerceIn(0, 42)
        prefs.edit().putInt(KEY_LAST_READ_VERSE, lastReadVerseIndex).apply()
    }

    fun updateJaapCount(count: Int) {
        jaapCount = count.coerceAtLeast(0)
        prefs.edit().putInt(KEY_JAAP_COUNT, jaapCount).apply()
    }

    fun incrementJaapCount(): Int {
        val newCount = jaapCount + 1
        jaapCount = newCount
        jaapTotalCount += 1
        prefs.edit()
            .putInt(KEY_JAAP_COUNT, newCount)
            .putInt(KEY_JAAP_TOTAL_COUNT, jaapTotalCount)
            .apply()
        return newCount
    }

    fun decrementJaapCount(): Int {
        if (jaapCount > 0) {
            val newCount = jaapCount - 1
            jaapCount = newCount
            if (jaapTotalCount > 0) jaapTotalCount -= 1
            prefs.edit()
                .putInt(KEY_JAAP_COUNT, newCount)
                .putInt(KEY_JAAP_TOTAL_COUNT, jaapTotalCount)
                .apply()
        }
        return jaapCount
    }

    fun completeMala() {
        jaapMalasCompleted += 1
        prefs.edit().putInt(KEY_JAAP_MALAS_COMPLETED, jaapMalasCompleted).apply()
    }

    fun updateJaapTarget(target: Int) {
        jaapTarget = target
        prefs.edit().putInt(KEY_JAAP_TARGET, target).apply()
    }

    fun resetJaap() {
        jaapCount = 0
        prefs.edit().putInt(KEY_JAAP_COUNT, 0).apply()
    }

    fun toggleJaapVibrate(enabled: Boolean) {
        jaapVibrate = enabled
        prefs.edit().putBoolean(KEY_JAAP_VIBRATE, enabled).apply()
    }

    fun toggleJaapSound(enabled: Boolean) {
        jaapSound = enabled
        prefs.edit().putBoolean(KEY_JAAP_SOUND, enabled).apply()
    }

    companion object {
        private const val KEY_TEXT_SCALE = "key_text_scale"
        private const val KEY_LANGUAGE = "key_language"
        private const val KEY_THEME_MODE = "key_theme_mode"
        private const val KEY_SHOW_DEVANAGARI = "key_show_devanagari"
        private const val KEY_SHOW_TRANSLIT = "key_show_translit"
        private const val KEY_SHOW_HINDI_MEANING = "key_show_hindi_meaning"
        private const val KEY_SHOW_ENGLISH_MEANING = "key_show_english_meaning"
        private const val KEY_LAST_READ_VERSE = "key_last_read_verse"
        private const val KEY_JAAP_COUNT = "key_jaap_count"
        private const val KEY_JAAP_TARGET = "key_jaap_target"
        private const val KEY_JAAP_MALAS_COMPLETED = "key_jaap_malas_completed"
        private const val KEY_JAAP_TOTAL_COUNT = "key_jaap_total_count"
        private const val KEY_JAAP_VIBRATE = "key_jaap_vibrate"
        private const val KEY_JAAP_SOUND = "key_jaap_sound"
    }
}
