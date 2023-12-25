package com.silaeva.game_impl.presentation

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.runtime.remember
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
import com.silaeva.game_impl.domain.Card
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun GameScreen(viewModel: GameViewModel) {

    Column() {
        Column() {
            Row(
                modifier = Modifier.padding(start = 24.dp, top = 24.dp, end = 24.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Absolute.SpaceBetween,
            ) {
                TimerField(viewModel)
                ScoreField("${ viewModel.score.intValue }")
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

@OptIn(ExperimentalMaterial3Api::class, DelicateCoroutinesApi::class)
@Composable
fun PlayField(
    viewModel: GameViewModel
) {
    val cards = remember { viewModel.randomDiamondList }

    var firstCard: Card? = remember { null }

    fun cardClick(card: Card) {

        if (card.isFlipped) {
            Log.d("Click", "Клик по открытой карте")
            return
        }  // если карта уже открыта, то ничего не делаем

        if (firstCard == null) {  //если это первая открытая карта
            firstCard = card
            card.isFlipped = true
            Log.d("Click", "Первая открытая карта")
        }
        else {   // если это вторая открытая карта

            Log.d("Click", "Вторая открытая карта")
            card.isFlipped = true

            if (card.image == firstCard?.image) { // если карты совпадают
                Log.d("Click", "Изображения карт совпали")
                // обнуляем первую карту
                firstCard = null
                viewModel.count++
            } else {  //если карты не совпадают
                Log.d("Click", "Изображения не совпали")
                //переворачиваем обе карты
                GlobalScope.launch {
                    delay(1000)
                    firstCard?.let { it.isFlipped = false }
                    card.isFlipped = false
                    firstCard = null
                }
            }
        }
    }

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

                    cardClick(cards[index])

                    if (viewModel.count == viewModel.maxPair) viewModel.stopTimer()
                }
            ) {
                if (cards[index].isFlipped) {   // если карта перевернута показываем бриллиантик
                    Image(
                        painter = painterResource(id = cards[index].image),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(8.dp)
                            .align(Alignment.CenterHorizontally)
                    )
                } else {   // иначе показываем оборотную сторону
                    Image(
                        painter = painterResource(id = R.drawable.baseline_ac_unit_24),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(8.dp)
                            .align(Alignment.CenterHorizontally),
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
    ) {
        Image(
            painter = painterResource(R.drawable.baseline_access_alarms_24),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .height(30.dp),
            alignment = Alignment.CenterStart
        )
        Text(
            text = timer.formatTime(),
            modifier = Modifier
                .padding(4.dp)
                .align(Alignment.CenterVertically),
            style = Typography.timeText
        )
    }
}

fun Long.formatTime(): String {
    val seconds = this % 60
    val minutes = (this % 3600) / 60
    return String.format("%02d:%02d", minutes, seconds)
}
