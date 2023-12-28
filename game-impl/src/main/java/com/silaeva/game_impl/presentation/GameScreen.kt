package com.silaeva.game_impl.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.silaeva.common_ui.ScoreField
import com.silaeva.common_ui.typography.Colors
import com.silaeva.common_ui.typography.Typography
import com.silaeva.game_impl.R

@Composable
fun GameScreen(viewModel: GameViewModel) {

    Column() {
        Column() {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 24.dp, top = 24.dp, end = 24.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TimerField(viewModel)
                ScoreField("${viewModel.score.intValue}")
            }
            Text(
                text = stringResource(id = R.string.timer_comment),
                modifier = Modifier
                    .padding(start = 24.dp, top = 4.dp),
                fontSize = 16.sp,
                textAlign = TextAlign.Start
            )
        }

        PlayField(
            viewModel = viewModel
        )

        Text(
            text = stringResource(id = R.string.rules),
            modifier = Modifier.padding(start = 24.dp, top = 8.dp, bottom = 8.dp, end = 24.dp),
            style = Typography.rules,
            minLines = 3
        )
        Text(
            text = stringResource(id = R.string.fast),
            modifier = Modifier
                .padding(start = 24.dp, top = 8.dp, bottom = 8.dp, end = 24.dp)
                .align(Alignment.CenterHorizontally),
            style = Typography.rules
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlayField(
    viewModel: GameViewModel
) {
    val cards by viewModel.cardsFlow.collectAsState()
    LazyVerticalGrid(
        columns = GridCells.Fixed(4),
        modifier = Modifier
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalArrangement = Arrangement.Center
    ) {
        items(cards.size) { index ->
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Colors.gray
                ),
                modifier = Modifier
                    .padding(8.dp)
                    .width(70.dp)
                    .height(70.dp),
                onClick = { // обработка нажатия на карту
                    if (!viewModel.startGame) {
                        viewModel.startTimer()
                        viewModel.startGame = true
                    }

                    viewModel.onCardClick(cards[index])

                    if (viewModel.count == viewModel.maxPair) viewModel.stopTimer()
                }
            ) {
                if (cards[index].isOpen) {   // если карта перевернута показываем бриллиантик
                    Image(
                        painter = painterResource(id = cards[index].image),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxSize()
                    )
                } else {   // иначе показываем оборотную сторону
                    Image(
                        painter = painterResource(id = R.drawable.baseline_ac_unit_24),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxSize()
                    )
                }
            }
        }
    }
}

@Composable
fun TimerField(viewModel: GameViewModel) {
    val timer by viewModel.timer.collectAsState()

    Row(
        modifier = Modifier
            .fillMaxWidth(0.5f)
            .height(30.dp)
            .background(color = Colors.gray, shape = RoundedCornerShape(18.dp)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(R.drawable.baseline_access_alarms_24),
            contentDescription = null,
            modifier = Modifier
                .height(30.dp),
            alignment = Alignment.CenterStart
        )
        Text(
            text = timer.formatTime(),
            modifier = Modifier
                .padding(start = 50.dp),
            style = Typography.timeText
        )


    }
}

fun Long.formatTime(): String {
    val seconds = this % 60
    val minutes = (this % 3600) / 60
    return String.format("%02d:%02d", minutes, seconds)
}
