package com.silaeva.end_impl.presentation

import androidx.lifecycle.ViewModel
import com.github.terrakok.cicerone.Router

class EndGameViewModel(
    private val router: Router
): ViewModel() {
    fun onBackButtonClick() {
        router.exit()
    }
}