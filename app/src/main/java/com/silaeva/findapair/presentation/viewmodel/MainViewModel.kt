package com.silaeva.findapair.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.silaeva.menu_api.MenuNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val menuNavigator: MenuNavigator
): ViewModel() {

    var isNav = 0

    fun goTo() {
        isNav = 1
        menuNavigator.navigateToMenu()
    }
}