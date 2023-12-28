package com.silaeva.menu_impl.presentation

import androidx.lifecycle.ViewModel
import com.silaeva.data_impl.data.ScoreInteractor
import com.silaeva.data_impl.data.datamodel.Score
import com.silaeva.data_impl.data.repository.RepositoryImpl
import com.silaeva.game_api.GameNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class MenuViewModel @Inject constructor(
    private val gameNavigator: GameNavigator,
    //repositoryImpl: RepositoryImpl
    //private val scoreInteractor: ScoreInteractor
) : ViewModel() {

    //val score: Flow<Score> = scoreInteractor.getScore()
    //val score: Flow<Score> = repositoryImpl.getScore()
    val score = 100

    fun onPlayButtonClick() {
        gameNavigator.navigateToGame()
    }
}