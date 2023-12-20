package com.silaeva.common_ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.silaeva.common_ui.typography.Typography

@Composable
fun ScoreLabel(
    modifier: Modifier = Modifier,
    text: String) {
    Row(
        modifier = modifier
            .padding(4.dp)
    ){
        Image(
            painter = painterResource(id = R.drawable.baseline_brightness_1_24),
            contentDescription = stringResource(id = R.string.score_description),
            modifier = Modifier,
            alignment = Alignment.CenterStart
        )
        Text(
            text = text,
            style = Typography.scoreText
        )
    }
}