package com.geromino_apps.domain.interactors.quote

import com.geromino_apps.domain.entities.QuoteEntity
import com.geromino_apps.domain.gateway.IGateWayArgumented

class QuotesInteractorImpl(private val mGateWay : IGateWayArgumented<List<QuoteEntity> , Long>) : QuotesInteractor{
    override fun storeQuotes(entities: List<QuoteEntity>) {
        mGateWay.store(entities)
    }

    override fun getQuotes(fromTimeStamp : Long): List<QuoteEntity> {
        return mGateWay.query(fromTimeStamp)
    }
}