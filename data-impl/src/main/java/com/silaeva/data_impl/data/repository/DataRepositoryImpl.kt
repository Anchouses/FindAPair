package com.silaeva.data_impl.data.repository

import android.app.Application
import android.content.Context
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
    override fun getScore(): Flow<Score> {
        return scoreDao.getScore()
    }

    override fun addScore(score: Score) {
        executor.execute {
            scoreDao.addScore(score)
        }
    }

    override fun updateScore(score: Score) {
        executor.execute {
            scoreDao.updateScore(score)
        }
    }

//    companion object {
//        private var INSTANCE: RepositoryImpl? = null
//
//        fun initialize(context: Context) {
//            if (INSTANCE == null) {
//                INSTANCE = RepositoryImpl()
//            }
//        }
//
//        fun get(): RepositoryImpl {
//            return INSTANCE ?:
//            throw IllegalStateException("where your repository?")
//        }
//    }
}