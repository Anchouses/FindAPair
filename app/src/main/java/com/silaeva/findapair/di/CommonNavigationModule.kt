package com.silaeva.findapair.di

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ActivityComponent::class, ViewModelComponent::class)
object CommonNavigationModule {
    @get:Provides
    val cicerone: Cicerone<Router> = Cicerone.create()
    @get:Provides
    val router: Router = cicerone.router
    @get:Provides
    val navigatorHolder: NavigatorHolder = cicerone.getNavigatorHolder()
}