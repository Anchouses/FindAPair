package com.silaeva.menu_impl.di

import com.silaeva.menu_impl.data.repository.MenuRepositoryImpl
import com.silaeva.menu_impl.domain.MenuRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ActivityComponent::class, ViewModelComponent::class)
interface MenuRepositoryModule {

    @Binds
    fun bindMenuRepository(impl: MenuRepositoryImpl): MenuRepository
}