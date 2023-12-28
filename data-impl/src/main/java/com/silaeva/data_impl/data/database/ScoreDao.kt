package com.silaeva.data_impl.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.silaeva.data_impl.data.datamodel.Score
import kotlinx.coroutines.flow.Flow

@Dao
interface ScoreDao {

    @Query("SELECT * FROM Score")
    fun getScore(): Flow<Score>

    @Insert
    fun addScore(score: Score)

    @Update
    fun updateScore(score: Score)

}