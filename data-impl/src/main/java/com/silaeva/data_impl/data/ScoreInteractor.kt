package com.silaeva.data_impl.data

import com.silaeva.data_impl.data.datamodel.Score
import com.silaeva.data_impl.data.repository.RepositoryInterface
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ScoreInteractor (private val repository: RepositoryInterface) {

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