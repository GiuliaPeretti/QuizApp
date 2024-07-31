package com.example.quizapp.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

val DarkColorScheme = darkColorScheme(
    background = ThemeColors.Night.background,
    primary = ThemeColors.Night.primary,
    secondary = ThemeColors.Night.secondary,
    tertiary = ThemeColors.Night.tertiary,
    onBackground = ThemeColors.Night.onBackgorund,
    onPrimary = ThemeColors.Night.onPrimary
)

val LightColorScheme = lightColorScheme(
    background = ThemeColors.Day.background,
    primary = ThemeColors.Day.primary,
    secondary = ThemeColors.Day.secondary,
    tertiary = ThemeColors.Day.tertiary,
    onBackground = ThemeColors.Night.onBackgorund,
    onPrimary = ThemeColors.Night.onPrimary

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun QuizAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}

@Composable
fun Theme(): ColorScheme {
    val colorScheme = if(isSystemInDarkTheme()) DarkColorScheme else LightColorScheme
    return colorScheme
}