package com.geromino_apps.presentation.screens.quotes

import com.geromino_apps.domain.entities.QuoteEntity
import com.geromino_apps.presentation.common.views.ObservableViewMVC
import com.geromino_apps.presentation.common.views.ViewMVCFactory

interface QuotesViewMVC : ObservableViewMVC<QuotesViewMVC.Listener>{

    interface Listener{
        fun onAddQuoteIsClicked(author : String, quote : String)
    }

    fun clearQuoteEditText()
    fun clearAuthorEditText()
    fun bindQuotes(quotes : List<QuoteEntity>, viewFactory : ViewMVCFactory)
    fun quoteAdded()
    fun setProgressBarVisibility(isVisible : Boolean)
    fun setEmptyStateVisibility(isVisible: Boolean)
    fun isAdapterIsEmpty() : Boolean

}