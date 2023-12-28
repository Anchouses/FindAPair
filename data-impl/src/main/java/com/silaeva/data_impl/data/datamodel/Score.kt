package com.silaeva.data_impl.data.datamodel

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Score(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    @ColumnInfo(name = "score")
    val score: Int
)