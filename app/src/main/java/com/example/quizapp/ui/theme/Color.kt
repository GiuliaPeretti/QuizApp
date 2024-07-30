package com.example.quizapp.ui.theme

import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

sealed class ThemeColors(
    val background: Color,
    val secondary: Color,
    val primary: Color,
    val tertiary: Color,
    val onBackgorund: Color,
    val onPrimary: Color
) {
    object Night : ThemeColors(
        background = Color(0xFF000000),
        primary = Color(0xFF0a0396),
        secondary = Color(0xFF6b4c61),
        tertiary = Color(0xFFd91698),
        onBackgorund = Color(0xFFFFFFFF),
        onPrimary = Color(0xFFFFFFFF),
    )
    object Day : ThemeColors(
        background = Color(0xFFFFFFFF),
        primary = Color(0xFF0a0396),
        secondary = Color(0xFFC8C8C8),
        tertiary = Color(0xFFed9fc9),
        onBackgorund = Color(0xFF000000),
        onPrimary = Color(0xFFFFFFFF),

        )
}