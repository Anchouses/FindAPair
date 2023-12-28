package com.silaeva.data_impl.data

import com.silaeva.data_impl.data.datamodel.Score
import com.silaeva.data_impl.data.repository.DataRepositoryInterface
import kotlinx.coroutines.flow.Flow

class ScoreInteractor (private val repository: DataRepositoryInterface) {

    fun getScore(): Flow<Score> {
        return repository.getScore()
    }
    fun addScore(score: Score) {
        return repository.addScore(score)
    }
    fun updateScore(score: Score){
        return repository.updateScore(score)
    }
}