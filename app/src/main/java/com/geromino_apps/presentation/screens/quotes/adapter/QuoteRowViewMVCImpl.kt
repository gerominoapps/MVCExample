package com.geromino_apps.presentation.screens.quotes.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import com.geromino_apps.R
import com.geromino_apps.presentation.common.views.BaseViewMvc

class QuoteRowViewMVCImpl (mInflater: LayoutInflater, root: ViewGroup?) : BaseViewMvc(), QuoteRowViewMVC{

    private val mAuthorTv : AppCompatTextView
    private val mQuoteTv : AppCompatTextView

    init {
        setRootView(mInflater.inflate(R.layout.row_quote, root, false))
        mAuthorTv = findViewById(R.id.author_tv)
        mQuoteTv = findViewById(R.id.quote_tv)
    }

    override fun setAuthor(text: String) {
        mAuthorTv.text = text
    }

    override fun setQuote(text: String) {
        mQuoteTv.text = text
    }
}