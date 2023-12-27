package com.silaeva.game_impl.presentation

import android.util.Log
import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.silaeva.end_api.EndGameNavigator
import com.silaeva.game_impl.R
import com.silaeva.game_impl.data.DataSource
import com.silaeva.game_impl.data.Diamond
import com.silaeva.game_impl.domain.Card
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(
    private val endGameNavigator: EndGameNavigator,
    private val dataSource: DataSource
) : ViewModel() {

    //dataSource.diamondList
    private val diamondList = listOf(
//        Diamond(R.drawable.blue_circle),
//        Diamond(R.drawable.blue_circle),
        Diamond(R.drawable.blue_circle),
        Diamond(R.drawable.blue_rhombus),
//        Diamond(R.drawable.green_circle),
//        Diamond(R.drawable.orange),
//        Diamond(R.drawable.pink_circle),
//        Diamond(R.drawable.purple_circle),
//        Diamond(R.drawable.red_circle),
//        Diamond(R.drawable.teal_circle),
//        Diamond(R.drawable.white_circle),
//        Diamond(R.drawable.yellow_circle),
    )

    private val randomDiamondList = (diamondList + diamondList).shuffled().map { Card(image = it.res) }
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
        val (curCard, prevCard, shouldClose) = cardComparing(card, firstCard)

        if (curCard.isOpen != card.isOpen) {
            cardsFlow.value = cardsFlow.value.map {                 //чтобы произошла рекомпозиция нужно чтобы лист изменился
                    if (it.uuid == curCard.uuid) {
                        curCard
                    } else {
                        it
                    }
                }
        }

        if (shouldClose) {               //закрываем обе карты
            viewModelScope.launch {
                delay(1000)
                cardsFlow.value = cardsFlow.value.map { it.copy(isOpen = false) }
            }
        }

        firstCard = prevCard                                    //состояние первой открытой карты определяем внутри метода cardComparing
    }


    private fun cardComparing(                                   //здесь проверяем открыта ли карта, открыта ли она первой или второй, совпадают ли изображения
        currentCard: Card,
        previousCard: Card?
    ): Triple<Card, Card?, Boolean> {                            //Triple<нажатая карта, предыдущая карта, надо ли переворачивать>

        if (currentCard.isOpen) {                                //если карта уже открыта, то ничего не делаем
            Log.d("Click", "Клик по открытой карте")
            return Triple(currentCard, previousCard, false)
        }

        val curCard = currentCard.copy(isOpen = true)      //если карта была закрыта, копируем ее в curCard со значением "открыта"

        if (previousCard == null) {                              //если это первая открытая карта
            return Triple(curCard, curCard, false)          //присваиваем предыдущей карте значение текущей карты
        } else {                                                 //если это вторая открытая карта
            if (curCard.image == previousCard.image) {           //если карты совпадают
                count++                                          //увеличиваем количество совпавших пар
                return Triple(curCard, null, false)  //и обнуляем первую карту
            } else {                                             //если карты не совпадают
                return Triple(curCard, null, true)   //закрываем обе карты
            }
        }
    }
}


//fun onCardClick(card: Card) {
//    val (curCard, prevCard, shouldFlip) = cardComparing(card, firstCard)
//
//    if (curCard.isFlipped != card.isFlipped) {
//        cardsFlow.value = cardsFlow.value.map {                 //чтобы произошла рекомпозиция нужно чтобы лист изменился
//            if (it.uuid == curCard.uuid) {
//                curCard
//            } else {
//                it
//            }
//        }
//    }
//
//    if (shouldFlip) {
//        viewModelScope.launch {
//            //переворачиваем обе карты
//            delay(1000)
//
//            cardsFlow.value = cardsFlow.value.map {
//                if (it.uuid == card.uuid || it.uuid == firstCard?.uuid) {
//                    it.copy(isFlipped = false)
//                } else {
//                    it
//                }
//            }
//        }
//    }
//
//    firstCard = prevCard                                    //состояние первой открытой карты определяем внутри метода cardComparing
//
//}
//
//
//private fun cardComparing(                                  //  здесь проверяем открыта ли карта, открыта ли она первой или второй, совпадают ли изображения
//    currentCard: Card,
//    previousCard: Card?
//): Triple<Card, Card?, Boolean> {                            //Triple<нажатая карта, предыдущая карта, надо ли переворачивать>
//
//    if (currentCard.isFlipped) {                             // если карта уже открыта, то ничего не делаем
//        Log.d("Click", "Клик по открытой карте")
//        return Triple(currentCard, previousCard, false)
//    }
//
//    val curCard = currentCard.copy(isFlipped = true)   //если карта была закрыта, копируем ее в curCard со значением "открыта"
//
//    if (previousCard == null) {                              //если это первая открытая карта
//        Log.d("Click", "Первая открытая карта")
//        return Triple(curCard, curCard, false)          //присваиваем предыдущей карте значение текущей карты
//    } else {                                                 //если это вторая открытая карта
//        Log.d("Click", "Вторая открытая карта")
//        if (curCard.image == previousCard.image) {           //если карты совпадают
//            Log.d("Click", "Изображения карт совпали")
//            count++                                          //увеличиваем количество совпавших пар
//            return Triple(curCard, null, false)  //и обнуляем первую карту
//        } else {                                             //если карты не совпадают
//            Log.d("Click", "Изображения не совпали")
//            return Triple(curCard, null, true)   //переворачиваем обе карты
//        }
//    }
//}