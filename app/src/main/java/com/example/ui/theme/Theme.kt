package com.example.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import com.example.data.AppThemeMode

private val LightDevotionalColorScheme = lightColorScheme(
    primary = SaffronPrimary,
    onPrimary = DevotionalCardLight,
    primaryContainer = SaffronContainer,
    onPrimaryContainer = SaffronOnContainer,
    secondary = SacredGold,
    onSecondary = DevotionalCardLight,
    secondaryContainer = SacredGoldContainer,
    onSecondaryContainer = SaffronOnContainer,
    tertiary = VermillionRed,
    onTertiary = DevotionalCardLight,
    background = DevotionalCream,
    onBackground = DevotionalTextPrimaryLight,
    surface = DevotionalCardLight,
    onSurface = DevotionalTextPrimaryLight,
    surfaceVariant = SacredGoldContainer,
    onSurfaceVariant = DevotionalTextSecondaryLight,
    outline = DevotionalBorderLight
)

private val SoftDarkDevotionalColorScheme = darkColorScheme(
    primary = SaffronPrimaryDark,
    onPrimary = DevotionalMidnightBg,
    primaryContainer = SaffronContainerDark,
    onPrimaryContainer = SaffronOnContainerDark,
    secondary = SacredGoldLight,
    onSecondary = DevotionalMidnightBg,
    secondaryContainer = DevotionalMidnightBorder,
    onSecondaryContainer = SaffronPrimaryDark,
    tertiary = MarigoldGold,
    onTertiary = DevotionalMidnightBg,
    background = DevotionalMidnightBg,
    onBackground = DevotionalTextPrimaryDark,
    surface = DevotionalMidnightCard,
    onSurface = DevotionalTextPrimaryDark,
    surfaceVariant = DevotionalMidnightBorder,
    onSurfaceVariant = DevotionalTextSecondaryDark,
    outline = DevotionalMidnightBorder
)

@Composable
fun HanumanChalisaTheme(
    appThemeMode: AppThemeMode = AppThemeMode.LIGHT,
    content: @Composable () -> Unit
) {
    val isDark = when (appThemeMode) {
        AppThemeMode.LIGHT -> false
        AppThemeMode.SOFT_DARK -> true
        AppThemeMode.SYSTEM -> isSystemInDarkTheme()
    }

    val colorScheme = if (isDark) SoftDarkDevotionalColorScheme else LightDevotionalColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
