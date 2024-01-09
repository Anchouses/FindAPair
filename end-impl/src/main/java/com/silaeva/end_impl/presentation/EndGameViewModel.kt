package com.silaeva.end_impl.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.terrakok.cicerone.Router
import com.silaeva.data_impl.data.datamodel.Score
import com.silaeva.data_impl.data.repository.RepositoryImpl
import com.silaeva.game_api.GameNavigator
import com.silaeva.menu_api.MenuNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EndGameViewModel @Inject constructor(
    private val router: Router,
    private val gameNavigator: GameNavigator,
    private val menuNavigator: MenuNavigator,
    private val dataRepositoryImpl: RepositoryImpl
): ViewModel() {

    var scoreList: List<Score> = emptyList()
    val flowScoreList: Flow<List<Score>> = dataRepositoryImpl.getScore()

    init {
        viewModelScope.launch {
            flowScoreList.collect() {
                scoreList = it
            }
        }
    }

    fun onBackButtonClick() {
        gameNavigator.navigateToGame()
    }

    fun onHomeButtonClick() {
        menuNavigator.navigateToMenu()
    }

    fun onExitButtonClick(){
        router.exit()
    }
}