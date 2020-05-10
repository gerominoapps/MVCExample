package com.geromino_apps.dependencyinjection.domain

import com.geromino_apps.data.gateway.quotes.QueryGateWay
import com.geromino_apps.domain.interactors.quote.QuotesInteractor
import com.geromino_apps.domain.interactors.quote.QuotesInteractorImpl
import dagger.Module
import dagger.Provides

@Module
class DomainModule {
    @Provides
    fun getQuotesInteractor() : QuotesInteractor{
        return QuotesInteractorImpl(QueryGateWay())
    }
}