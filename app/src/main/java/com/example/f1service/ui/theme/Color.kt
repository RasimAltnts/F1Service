package com.example.f1service.ui.theme

import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

class LightColorPalette private constructor() {
    companion object {

        val nextRaceGradientStart = Color(0xFFFFA800)
        val nextRaceGradientEnd = Color(0xCCFFFFFF)

        val background = Color(0xCCFFFFFF)
        val iconColor = Color(0xCC000000)

        val textColor = Color(0xCC000000)
    }
}

class DarkColorPalette private constructor() {
    companion object {

        val nextRaceGradientStart = Color(0xFFFFA800)
        val nextRaceGradientEnd = Color(0xA6181818)

        val background = Color(0xCCFFFFFF)
        val iconColor = Color(0xCCFFFFFF)

        val textColor = Color(0xCCFFFFFF)
    }
}