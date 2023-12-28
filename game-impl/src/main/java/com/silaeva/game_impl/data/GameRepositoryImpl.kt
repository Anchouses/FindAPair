package com.silaeva.game_impl.data

import com.silaeva.game_impl.domain.GameRepository
import javax.inject.Inject

class GameRepositoryImpl @Inject constructor(
    val dataSource: DataSource
) : GameRepository {
    override fun method() {
        TODO("Not yet implemented")
    }

}