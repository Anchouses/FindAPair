package com.silaeva.menu_impl.data


import com.silaeva.menu_impl.domain.MenuRepository
import javax.inject.Inject

class MenuRepositoryImpl @Inject constructor(
    val dataSource: DataSource
) : MenuRepository {
    override fun method() {
        TODO("Not yet implemented")
    }

}