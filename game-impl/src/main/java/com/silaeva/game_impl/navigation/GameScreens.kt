package com.silaeva.game_impl.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.silaeva.game_impl.presentation.GameFragment

class GameScreens(): FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment =
        GameFragment.newInstance()
}