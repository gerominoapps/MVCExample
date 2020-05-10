package com.geromino_apps.data.roomdb.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quotes")
data class QuoteEntity(
    @PrimaryKey
    @ColumnInfo(name = "timestamp") val timestamp: Long?,
    @ColumnInfo(name = "author") val author: String?,
    @ColumnInfo(name = "quote") val quote: String?
)