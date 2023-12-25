package com.silaeva.game_impl.presentation

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import com.silaeva.common_ui.typography.Colors
import com.silaeva.game_impl.R
import com.silaeva.game_impl.domain.Card
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun GameScreen(viewModel: GameViewModel) {

    Column {
        Column {
            Row {
                TimerField(viewModel)
                CountField(viewModel)
            }
            Text(
                text = stringResource(id = R.string.timer_comment),
                modifier = Modifier
                    .padding(start = 24.dp, top = 4.dp, bottom = 16.dp, end = 4.dp),
                fontSize = 16.sp,
                textAlign = TextAlign.Start
            )
        }

        PlayField(
            modifier = Modifier,
            viewModel = viewModel
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class, DelicateCoroutinesApi::class)
@Composable
fun PlayField(
    modifier: Modifier,
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
        //contentPadding = PaddingValues(16.dp),  //отступы вокруг сетки
        modifier = modifier
            .padding(24.dp)
    ) {
        items(cards.size) { index ->
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Colors.gray
                ),
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
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
                        modifier = Modifier.fillMaxSize()
                    )
                } else {   // иначе показываем оборотную сторону
                    Image(
                        painter = painterResource(id = R.drawable.baseline_ac_unit_24),
                        contentDescription = null,
                        modifier = Modifier.padding(8.dp)
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
            .padding(start = 24.dp, top = 16.dp, bottom = 4.dp, end = 24.dp)
            .fillMaxWidth(0.5f)
            .fillMaxHeight(0.05f)
            .background(color = Colors.gray, shape = RoundedCornerShape(18.dp)),
        horizontalArrangement = Arrangement.Start
    ) {
        Image(
            painter = painterResource(R.drawable.alarm),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.CenterVertically),
            alignment = Alignment.CenterStart
        )
        Text(
            text = timer.formatTime(),
            modifier = Modifier
                .padding(4.dp)
                .align(Alignment.CenterVertically),
            fontSize = 16.sp,
            textAlign = TextAlign.End
        )
    }
}

fun Long.formatTime(): String {
    val seconds = this % 60
    val minutes = (this % 3600) / 60
    return String.format("%02d:%02d", minutes, seconds)
}

@Composable
fun CountField(
    viewModel: GameViewModel
) {
    Row(
        modifier = Modifier
            .padding(24.dp)
            .fillMaxWidth(0.5f)
            .fillMaxHeight(0.05f),
        horizontalArrangement = Arrangement.Start
    ) {
        Image(
            painter = painterResource(id = R.drawable.coin),
            contentDescription = "Score",
            modifier = Modifier
                .align(Alignment.CenterVertically),
            alignment = Alignment.CenterStart
        )
        Text(
            text = " ${viewModel.score.intValue} ",
            modifier = Modifier
                .padding(4.dp)
                .align(Alignment.CenterVertically),
            fontSize = 16.sp,
            textAlign = TextAlign.End
        )
    }
}
