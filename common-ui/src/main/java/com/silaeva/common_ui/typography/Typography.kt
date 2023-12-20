package com.silaeva.common_ui.typography

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

object Typography {
    val title = TextStyle(
        fontSize = 22.sp,
        lineHeight = 26.sp,
        fontWeight = FontWeight(500),
        color = Color(0xFF000000)
    )
    val description = TextStyle(
        fontSize = 12.sp,
        lineHeight = 16.sp,
        fontWeight = FontWeight(400),
        color = Color(0xFF000000)
    )
    val scoreText = TextStyle(
        fontSize = 16.sp,
        lineHeight = 20.sp,
        fontWeight = FontWeight(400),
        color = Color(0xFF000000)
    )
    val congratulation = TextStyle(
        fontSize = 26.sp,
        lineHeight = 26.sp,
        fontWeight = FontWeight(700),
        color = Color(0xFF000000)
    )

}