package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.audio.AudioPlayerManager
import com.example.data.AppPreferences
import com.example.ui.screens.AudioPlayerScreen
import com.example.ui.screens.HomeScreen
import com.example.ui.screens.JaapCounterScreen
import com.example.ui.screens.ReadingScreen
import com.example.ui.screens.SettingsScreen
import com.example.ui.theme.HanumanChalisaTheme

sealed interface Screen {
    data object Home : Screen
    data class Reading(val initialVerseIndex: Int = 0) : Screen
    data object AudioPlayer : Screen
    data object Settings : Screen
    data object JaapCounter : Screen
}

class MainActivity : ComponentActivity() {
    private lateinit var preferences: AppPreferences
    private lateinit var audioManager: AudioPlayerManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        preferences = AppPreferences(applicationContext)
        audioManager = AudioPlayerManager(applicationContext)

        setContent {
            HanumanChalisaTheme(appThemeMode = preferences.themeMode) {
                ChalisaApp(
                    preferences = preferences,
                    audioManager = audioManager
                )
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        audioManager.release()
    }
}

@Composable
fun ChalisaApp(
    preferences: AppPreferences,
    audioManager: AudioPlayerManager
) {
    var currentScreen by remember { mutableStateOf<Screen>(Screen.Home) }

    Scaffold(modifier = Modifier.fillMaxSize()) { _ ->
        AnimatedContent(
            targetState = currentScreen,
            transitionSpec = {
                (slideInHorizontally { width -> width / 3 } + fadeIn())
                    .togetherWith(slideOutHorizontally { width -> -width / 3 } + fadeOut())
            },
            label = "screen_transition"
        ) { screen ->
            when (screen) {
                is Screen.Home -> {
                    HomeScreen(
                        preferences = preferences,
                        onNavigateToRead = { verseIndex ->
                            currentScreen = Screen.Reading(verseIndex)
                        },
                        onNavigateToListen = {
                            currentScreen = Screen.AudioPlayer
                        },
                        onNavigateToSettings = {
                            currentScreen = Screen.Settings
                        },
                        onNavigateToJaap = {
                            currentScreen = Screen.JaapCounter
                        }
                    )
                }

                is Screen.Reading -> {
                    ReadingScreen(
                        preferences = preferences,
                        initialVerseIndex = screen.initialVerseIndex,
                        onBack = { currentScreen = Screen.Home }
                    )
                }

                is Screen.AudioPlayer -> {
                    AudioPlayerScreen(
                        audioManager = audioManager,
                        preferences = preferences,
                        onBack = { currentScreen = Screen.Home }
                    )
                }

                is Screen.Settings -> {
                    SettingsScreen(
                        preferences = preferences,
                        onBack = { currentScreen = Screen.Home }
                    )
                }

                is Screen.JaapCounter -> {
                    JaapCounterScreen(
                        preferences = preferences,
                        audioManager = audioManager,
                        onBack = { currentScreen = Screen.Home }
                    )
                }
            }
        }
    }
}
