package com.silaeva.data_impl.di

import com.silaeva.data_impl.data.repository.RepositoryImpl
import com.silaeva.data_impl.data.repository.RepositoryInterface
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ActivityComponent::class, ViewModelComponent::class)
interface DataRepositoryModule {

    @Binds
    fun bindDataRepository(impl: RepositoryImpl): RepositoryInterface
}