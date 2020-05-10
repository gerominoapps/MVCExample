package com.geromino_apps.data.gateway.quotes

import com.geromino_apps.QuotesApplication
import com.geromino_apps.data.roomdb.db.AppDataBase
import com.geromino_apps.data.roomdb.mapper.QuoteMapUtils
import com.geromino_apps.domain.entities.QuoteEntity
import com.geromino_apps.domain.gateway.IGateWayArgumented
import javax.inject.Inject

class QueryGateWay : IGateWayArgumented<List<QuoteEntity>, Long> {

    @Inject
    lateinit var mDB: AppDataBase

    init {
        QuotesApplication.mApplicationComponent.inject(this)
    }

    override fun query(s: Long?): List<QuoteEntity> {
        s?.let {
            return QuoteMapUtils().mapToDomain(mDB.quoteDao().getCaptures(it))
        }
        return ArrayList()
    }

    override fun store(o: List<QuoteEntity>) {
        mDB.quoteDao().insertAll(*(QuoteMapUtils().mapToDAO(o)).toTypedArray())
    }
}