package com.silaeva.end_impl.presentation

import androidx.lifecycle.ViewModel
import com.github.terrakok.cicerone.Router
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EndGameViewModel @Inject constructor(
    private val router: Router
): ViewModel() {
    fun onBackButtonClick() {
        router.exit()
    }
}