package com.silaeva.game_impl.presentation

import androidx.lifecycle.ViewModel
import com.silaeva.end_api.EndNavigator

class GameViewModel(
    private val endNavigator: EndNavigator
) : ViewModel() {

    fun onTimeOut() {
        endNavigator.navigateToEnd()
    }
}