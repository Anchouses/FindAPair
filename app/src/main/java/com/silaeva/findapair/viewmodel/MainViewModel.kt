package com.silaeva.findapair.viewmodel

import androidx.lifecycle.ViewModel
import com.silaeva.menu_api.MenuNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val menuNavigator: MenuNavigator,
): ViewModel() {

    fun goTo() {
        menuNavigator.navigateToMenu()
    }
}