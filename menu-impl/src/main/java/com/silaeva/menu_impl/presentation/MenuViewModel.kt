package com.silaeva.menu_impl.presentation

import androidx.lifecycle.ViewModel
import com.silaeva.game_api.GameNavigator

class MenuViewModel(
    private val gameNavigator: GameNavigator
) : ViewModel() {

    fun onPlayButtonClick() {
        gameNavigator.navigateToGame()
    }
}