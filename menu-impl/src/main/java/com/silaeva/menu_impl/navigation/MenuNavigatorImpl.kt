package com.silaeva.menu_impl.navigation

import com.github.terrakok.cicerone.Router
import com.silaeva.menu_api.MenuNavigator
import javax.inject.Inject

class MenuNavigatorImpl @Inject constructor(
    private val router: Router
): MenuNavigator {
    override fun navigateToMenu() {
        router.navigateTo(MenuScreens())
    }
}