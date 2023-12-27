package com.silaeva.menu_impl.data.repository

import android.content.Context
import androidx.room.Room
import com.silaeva.menu_impl.data.database.ScoreDatabase
import com.silaeva.menu_impl.data.datamodel.Score
import com.silaeva.menu_impl.domain.MenuRepository
import kotlinx.coroutines.flow.Flow
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Inject

const val DATABASE_NAME = "Score"
class MenuRepositoryImpl @Inject constructor(
    context: Context
): MenuRepository {

    private val database: ScoreDatabase = Room.databaseBuilder(
        context.applicationContext,
        ScoreDatabase::class.java,
        DATABASE_NAME
    ).build()

    private val scoreDao = database.scoreDao()

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
}