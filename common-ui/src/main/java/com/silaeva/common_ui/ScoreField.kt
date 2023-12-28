package com.silaeva.common_ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.silaeva.common_ui.typography.Typography

@Composable
fun ScoreField(
    text: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End
    ) {
        Image(
            painter = painterResource(id = R.drawable.coin),
            contentDescription = "Score",
            modifier = Modifier
                .height(24.dp)
        )
        Text(
            text = text,
            modifier = Modifier
                .padding(4.dp),
            style = Typography.description,
            textAlign = TextAlign.End
        )
    }
}