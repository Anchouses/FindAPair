package com.silaeva.game_impl.presentation

import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.silaeva.end_api.EndGameNavigator
import com.silaeva.game_impl.data.DataSource
import com.silaeva.game_impl.domain.Card
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject
import kotlin.Unit

@HiltViewModel
class GameViewModel @Inject constructor(
    private val endGameNavigator: EndGameNavigator,
    private val dataSource: DataSource
) : ViewModel() {

    //dataSource.diamondList
    private val diamondList = dataSource.diamondList
//        listOf(
////        Diamond(R.drawable.blue_circle),
////        Diamond(R.drawable.blue_circle),
//        Diamond(R.drawable.blue_circle),
//        Diamond(R.drawable.blue_rhombus),
////        Diamond(R.drawable.green_circle),
////        Diamond(R.drawable.orange),
////        Diamond(R.drawable.pink_circle),
////        Diamond(R.drawable.purple_circle),
////        Diamond(R.drawable.red_circle),
////        Diamond(R.drawable.teal_circle),
////        Diamond(R.drawable.white_circle),
////        Diamond(R.drawable.yellow_circle),
//    )

    private val randomDiamondList = (diamondList + diamondList).shuffled().map { Card(image = it.image) }
    val maxPair = diamondList.size
    private val maxTime = 20
    var count = 0
    var score = mutableIntStateOf(0)
    private val _timer = MutableStateFlow(0L)
    val timer = _timer.asStateFlow()
    var startGame = false
    private var timerJob: Job? = null
    private var wait: Job? = null

    val cardsFlow = MutableStateFlow(randomDiamondList)
    private var firstCard: Card? = null

    fun startTimer() {
        _timer.value = 0
        timerJob?.cancel()
        timerJob = viewModelScope.launch {
            while (true) {
                delay(1000)
                _timer.value++
            }
        }
    }

    fun stopTimer() {
        timerJob?.cancel()

        val time = _timer.value.toInt()
        if (time <= maxTime) {
            score.intValue = 100
        } else if (time > maxTime) {
            val scoreLongGame = (100 - (time - maxTime) * 5)
            score.intValue = if (scoreLongGame < 10) 10 else scoreLongGame
        }

        wait?.cancel()
        wait = viewModelScope.launch {
            delay(2000)
            onTimeOut()
        }
    }

    private fun onTimeOut() {
        endGameNavigator.navigateToEnd()
    }

    fun onCardClick(card: Card) {
        val result = cardComparing(card, firstCard)

        if (result != Result.OpenCardClick) {
            cardsFlow.value = cardsFlow.value.map {                 //чтобы произошла рекомпозиция нужно чтобы лист изменился
                if (it.uuid == card.uuid) {
                    it.copy(isOpen = true)
                } else {
                    it
                }
            }
        }

        when (result) {
            Result.OpenCardClick -> Unit
            Result.FirstCardClick -> {
                firstCard = card
            }
            Result.RightCards -> {
                count++
                firstCard = null
            }
            Result.WrongCards -> {
                viewModelScope.launch {
                    delay(500)

                    cardsFlow.value = cardsFlow.value.map {
                        if (it.uuid == card.uuid || it.uuid == firstCard?.uuid) {
                            it.copy(isOpen = false)
                        } else {
                            it
                        }
                    }
                    firstCard = null
                }
            }
        }
    }

    private fun cardComparing(
        currentCard: Card,
        previousCard: Card?
    ): Result {

        if (currentCard.isOpen) {
            return Result.OpenCardClick
        }

        val curCard = currentCard.copy(isOpen = true)

        if (previousCard == null) {
            return Result.FirstCardClick
        } else {
            if (curCard.image == previousCard.image) {
                return Result.RightCards
            } else {
                return Result.WrongCards
            }
        }
    }

}

private sealed interface Result {
    data object OpenCardClick: Result
    data object FirstCardClick: Result
    data object WrongCards: Result
    data object RightCards: Result
}