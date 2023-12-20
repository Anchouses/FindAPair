package com.silaeva.end_impl.navigation

import com.github.terrakok.cicerone.Router
import com.silaeva.end_api.EndNavigator

class EndNavigatorImpl(
    private val router: Router
) : EndNavigator {
    override fun navigateToEnd() {
        router.navigateTo(EndScreens())
    }
}