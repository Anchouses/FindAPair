package com.silaeva.data_impl.data.repository

import com.silaeva.data_impl.data.datamodel.Score
import kotlinx.coroutines.flow.Flow

interface DataRepositoryInterface {
    fun getScore(): Flow<Score>
    fun addScore(score: Score)
    fun updateScore(score: Score)
}