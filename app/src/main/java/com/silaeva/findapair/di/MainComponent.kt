package com.silaeva.findapair.di

import com.silaeva.end_impl.di.EndNavigationModule
import com.silaeva.game_impl.di.GameNavigationModule
import com.silaeva.menu_impl.di.MenuNavigationModule
import dagger.Component


@Component(
    dependencies = [MenuModuleDependencies::class, GameModuleDependencies::class, EndModuleDependencies::class],
    modules = [MenuNavigationModule::class, GameNavigationModule::class, EndNavigationModule::class]
)

interface MainComponent