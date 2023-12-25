package com.silaeva.menu_impl.presentation

import androidx.lifecycle.ViewModel
import com.silaeva.game_api.GameNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MenuViewModel @Inject constructor(
    private val gameNavigator: GameNavigator
) : ViewModel() {

    val score = 100
    fun onPlayButtonClick() {
        gameNavigator.navigateToGame()
    }
}