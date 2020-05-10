package com.geromino_apps.data.roomdb.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.geromino_apps.data.roomdb.entities.QuoteEntity

@Dao
interface QuoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg quotes: QuoteEntity)

    @Query("SELECT * FROM quotes WHERE timestamp < (:fromTimeStamp) ORDER BY timestamp DESC")
    fun getCaptures(fromTimeStamp: Long): List<QuoteEntity>
}