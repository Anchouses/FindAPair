package com.silaeva.game_impl.navigation

import com.github.terrakok.cicerone.Router
import com.silaeva.game_api.GameNavigator

class GameNavigatorImpl(
    private val router: Router
): GameNavigator {
    override fun navigateToGame() {
        router.navigateTo(GameScreens())
    }
}