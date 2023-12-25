package com.silaeva.game_impl.di

import com.silaeva.game_api.GameNavigator
import com.silaeva.game_impl.navigation.GameNavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ActivityComponent::class, ViewModelComponent::class)
interface GameNavigationModule {

    @Binds
    fun gameNavigation(impl: GameNavigatorImpl): GameNavigator
}