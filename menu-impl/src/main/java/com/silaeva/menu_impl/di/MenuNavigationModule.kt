package com.silaeva.menu_impl.di

import com.silaeva.menu_api.MenuNavigator
import com.silaeva.menu_impl.navigation.MenuNavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ActivityComponent::class, ViewModelComponent::class)
interface MenuNavigationModule {
    @Binds
    fun bindMenuNavigation(impl: MenuNavigatorImpl): MenuNavigator
}