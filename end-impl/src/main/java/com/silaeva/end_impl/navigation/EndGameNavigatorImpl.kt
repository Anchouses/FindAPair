package com.silaeva.end_impl.navigation

import com.github.terrakok.cicerone.Router
import com.silaeva.end_api.EndGameNavigator
import javax.inject.Inject

class EndGameNavigatorImpl @Inject constructor(
    private val router: Router
) : EndGameNavigator {
    override fun navigateToEnd() {
        router.navigateTo(EndGameScreens())
    }
}