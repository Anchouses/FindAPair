package com.silaeva.data_impl.data.repository

import com.silaeva.data_impl.data.datamodel.Score
import kotlinx.coroutines.flow.Flow

interface DataRepositoryInterface {
    fun getScore(): Flow<List<Score>>
    fun addScore(score: Int)
    fun updateScore(score: Int)
}