package com.silaeva.data_impl.data.datamodel

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "score")
data class Score(
    @PrimaryKey(autoGenerate = true)
    var id: Int?,
    @ColumnInfo
    var score: Int
)