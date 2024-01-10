package com.silaeva.data_impl.di

import android.app.Application
import androidx.room.Room
import com.silaeva.data_impl.data.database.ScoreDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDb(application: Application): ScoreDatabase {
        return Room.databaseBuilder(
            application,
            ScoreDatabase::class.java,
            "score"
        ).build()
    }

    @Provides
    @Singleton
    fun provideDao(scoreDatabase: ScoreDatabase) = scoreDatabase.scoreDao()
}