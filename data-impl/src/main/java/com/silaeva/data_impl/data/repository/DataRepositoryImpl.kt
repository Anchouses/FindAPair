package com.silaeva.data_impl.data.repository

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.room.Dao
import androidx.room.Room
import com.silaeva.data_impl.data.database.ScoreDao
import com.silaeva.data_impl.data.database.ScoreDatabase
import com.silaeva.data_impl.data.datamodel.Score
import kotlinx.coroutines.flow.Flow
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Inject

const val DATABASE_NAME = "Score"

class RepositoryImpl @Inject constructor (
    private val scoreDao: ScoreDao
): DataRepositoryInterface {

    private val executor: Executor = Executors.newSingleThreadExecutor()
    override fun getScore(): Flow<List<Score>> {
        return scoreDao.getScore()
    }

    override fun addScore(score: Int) {
        val saveScore = Score(id = null, score = score)
        Log.d("score", "$saveScore")
        executor.execute {
            scoreDao.addScore(saveScore)
        }
    }

    override fun updateScore(score: Int) {
        val updateScore = Score(id = null, score = score)
        executor.execute {
            scoreDao.updateScore(updateScore)
        }
    }

//    companion object {
//        private var INSTANCE: RepositoryImpl? = null
//
//        fun initialize(context: Context) {
//            if (INSTANCE == null) {
//                INSTANCE = RepositoryImpl(context)
//            }
//        }
//
//        fun get(): RepositoryImpl {
//            return INSTANCE ?:
//            throw IllegalStateException("where your repository?")
//        }
//    }
}