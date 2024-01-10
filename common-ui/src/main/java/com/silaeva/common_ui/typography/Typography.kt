package com.silaeva.common_ui.typography

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

object Typography {
    val title = TextStyle(
        fontSize = 30.sp,
        lineHeight = 34.sp,
        fontWeight = FontWeight(500),
        color = Color(0xFF000000),
        textAlign = TextAlign.Center
    )
    val description = TextStyle(
        fontSize = 24.sp,
        lineHeight = 28.sp,
        fontWeight = FontWeight(400),
        color = Color(0xFF000000)
    )
    val timeText = TextStyle(
        fontSize = 16.sp,
        lineHeight = 20.sp,
        fontWeight = FontWeight(400),
        color = Color(0xFF000000)
    )

    val rules = TextStyle(
        fontSize = 16.sp,
        lineHeight = 20.sp,
        fontWeight = FontWeight(400),
        color = Color(0xFF000000),
        textAlign = TextAlign.Center
    )

    val congratulation = TextStyle(
        fontSize = 28.sp,
        lineHeight = 32.sp,
        fontWeight = FontWeight(700),
        color = Color(0xFF000000)
    )

}