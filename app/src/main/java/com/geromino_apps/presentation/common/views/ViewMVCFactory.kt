package com.geromino_apps.presentation.common.views

import android.view.LayoutInflater
import android.view.ViewGroup
import com.geromino_apps.presentation.screens.quotes.QuotesViewMVCImpl
import com.geromino_apps.presentation.screens.quotes.adapter.QuoteRowViewMVC
import com.geromino_apps.presentation.screens.quotes.adapter.QuoteRowViewMVCImpl

class ViewMVCFactory(layoutInflater: LayoutInflater) {

    private val mInflater = layoutInflater

    fun getQuoteViewMVC(root : ViewGroup?) : com.geromino_apps.presentation.screens.quotes.QuotesViewMVC {
        return  QuotesViewMVCImpl(mInflater, root)
    }

    fun getQuotesRow(root : ViewGroup?) : QuoteRowViewMVC {
        return QuoteRowViewMVCImpl(mInflater, root)
    }
}