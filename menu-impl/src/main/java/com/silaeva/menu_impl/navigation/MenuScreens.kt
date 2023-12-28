package com.silaeva.menu_impl.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.silaeva.menu_impl.presentation.MenuFragment

class MenuScreens () : FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment =
        MenuFragment.newInstance()

}