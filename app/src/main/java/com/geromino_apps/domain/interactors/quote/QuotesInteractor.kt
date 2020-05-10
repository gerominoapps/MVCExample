package com.geromino_apps.domain.interactors.quote

import com.geromino_apps.domain.entities.QuoteEntity

interface QuotesInteractor {
    fun storeQuotes(entities : List<QuoteEntity>)
    fun getQuotes(fromTimeStamp : Long) : List<QuoteEntity>
}