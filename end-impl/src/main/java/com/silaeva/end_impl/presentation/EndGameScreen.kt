package com.silaeva.end_impl.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.silaeva.common_ui.CardContainer
import com.silaeva.common_ui.ScoreField
import com.silaeva.common_ui.typography.Colors
import com.silaeva.common_ui.typography.Typography
import com.silaeva.data_impl.data.datamodel.Score
import com.silaeva.end_impl.R


@Composable
fun EndGameScreen(
    viewModel: EndGameViewModel
) {
    val score by viewModel.score.collectAsState(initial = Score(score = 0))
    Column(
        modifier = Modifier.padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.cup),
            contentDescription = null,
            modifier = Modifier
                .padding(16.dp)
                .height(150.dp)
                .width(150.dp)
        )
        Text(
            text = stringResource(id = R.string.congratulation),
            modifier = Modifier.padding(8.dp),
            style = Typography.congratulation
        )
        Text(
            text = stringResource(id = R.string.great),
            modifier = Modifier.padding(8.dp),
            style = Typography.description
        )
        CardContainer(
            modifier = Modifier
                .padding(bottom = 16.dp)
                .fillMaxWidth(0.9f)
                .height(100.dp)
        ) {
            Box(
                modifier = Modifier
                    .padding(top = 24.dp)
                    .align(Alignment.CenterHorizontally),
            ) { ScoreField(text = "{${score.score}}") }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = { viewModel.onBackButtonClick() },
                modifier = Modifier
                    .height(70.dp),
            ) {
                Text(
                    text = stringResource(id = R.string.double_reward),
                    style = Typography.description,
                    color = Colors.white
                )
            }
            CardContainer(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .width(90.dp)
                    .height(90.dp)
                    .clickable(
                        onClick = {
                            viewModel.onHomeButtonClick()
                        }
                    )
            ) {
                Image(
                    painter = painterResource(id = R.drawable.baseline_cottage_24),
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .width(70.dp),
                    alignment = Alignment.Center
                )
            }
        }
    }
}

