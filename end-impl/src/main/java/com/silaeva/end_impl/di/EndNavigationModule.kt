package com.silaeva.end_impl.di

import com.silaeva.end_api.EndGameNavigator
import com.silaeva.end_impl.navigation.EndGameNavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ActivityComponent::class, ViewModelComponent::class)
interface EndNavigationModule {

    @Binds
    fun endGameNavigator(impl: EndGameNavigatorImpl): EndGameNavigator
}