package com.geromino_apps.data.roomdb.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.geromino_apps.data.roomdb.dao.QuoteDao
import com.geromino_apps.data.roomdb.entities.QuoteEntity

@Database(entities = [QuoteEntity::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun quoteDao(): QuoteDao
}