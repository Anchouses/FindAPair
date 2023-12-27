package com.silaeva.menu_impl.domain

import com.silaeva.menu_impl.data.datamodel.Score
import kotlinx.coroutines.flow.Flow

interface MenuRepository {
    fun getScore(): Flow<Score>
    fun addScore(score: Score)
    fun updateScore(score: Score)
}