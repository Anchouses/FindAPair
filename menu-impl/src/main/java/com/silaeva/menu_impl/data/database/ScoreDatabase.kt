package com.silaeva.menu_impl.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.silaeva.menu_impl.data.datamodel.Score

@Database (entities = [Score::class], version = 1)
abstract class ScoreDatabase : RoomDatabase() {

    abstract fun scoreDao(): ScoreDao
}