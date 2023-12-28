package com.silaeva.game_impl.di

import com.silaeva.game_impl.data.GameRepositoryImpl
import com.silaeva.game_impl.domain.GameRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ActivityComponent::class, ViewModelComponent::class)
interface GameRepositoryModule {
    @Binds
    fun bindGameRepository(impl: GameRepositoryImpl): GameRepository
}