package com.silaeva.data_impl.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.silaeva.data_impl.data.datamodel.Score

@Database(entities = [Score::class], version = 2)
abstract class ScoreDatabase : RoomDatabase() {

    abstract fun scoreDao(): ScoreDao
}