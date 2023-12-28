package com.silaeva.data_impl.di

import com.silaeva.data_impl.data.repository.RepositoryImpl
import com.silaeva.data_impl.data.repository.DataRepositoryInterface
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
interface DataRepositoryModule {

    @Binds
    fun bindDataRepository(impl: RepositoryImpl): DataRepositoryInterface
}