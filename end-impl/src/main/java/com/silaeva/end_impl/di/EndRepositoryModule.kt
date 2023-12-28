package com.silaeva.end_impl.di

import com.silaeva.end_impl.data.EndGameRepositoryImpl
import com.silaeva.end_impl.domain.EndGameRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ActivityComponent::class, ViewModelComponent::class)
interface EndRepositoryModule {

    @Binds
    fun bindEndRepository(impl: EndGameRepositoryImpl): EndGameRepository
}