package com.silaeva.end_impl.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.silaeva.end_impl.presentation.EndGameFragment

class EndScreens() : FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment =
        EndGameFragment.newInstance()
}