package com.geromino_apps.presentation.screens.quotes.adapter

import com.geromino_apps.presentation.common.views.ViewMvc

interface QuoteRowViewMVC : ViewMvc{

    fun setAuthor(text : String)
    fun setQuote(text : String)
}