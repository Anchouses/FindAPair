package com.silaeva.findapair.viewmodel

import androidx.lifecycle.ViewModel
import com.silaeva.menu_api.MenuNavigator

class MainViewModel(
    private val menuNavigator: MenuNavigator,
): ViewModel() {

    fun goTo() {
        menuNavigator.navigateToMenu()
    }
}