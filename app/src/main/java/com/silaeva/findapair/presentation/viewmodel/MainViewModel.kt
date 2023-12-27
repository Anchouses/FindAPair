package com.silaeva.findapair.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.silaeva.end_api.EndGameNavigator
import com.silaeva.game_api.GameNavigator
import com.silaeva.menu_api.MenuNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val menuNavigator: MenuNavigator,
    private val gameNavigator: GameNavigator,
    private val endGameNavigator: EndGameNavigator
): ViewModel() {

    var selectedFragmentIndex = 0
    fun goTo(screenIndex: Int) {
        when(screenIndex){
            1 -> menuNavigator.navigateToMenu()
            2 -> gameNavigator.navigateToGame()
            3 -> endGameNavigator.navigateToEnd()
        }

    }
}