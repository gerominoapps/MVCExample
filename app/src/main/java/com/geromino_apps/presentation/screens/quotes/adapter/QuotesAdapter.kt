package com.geromino_apps.presentation.screens.quotes.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.geromino_apps.domain.entities.QuoteEntity
import com.geromino_apps.presentation.common.views.ViewMVCFactory


class QuotesAdapter(quotes : List<QuoteEntity>, private val mViewMVCFactory: ViewMVCFactory) :  RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var mQuotes : List<QuoteEntity> = quotes

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return QuoteViewHolder(mViewMVCFactory.getQuotesRow(parent))
    }

    override fun getItemCount(): Int {
        return mQuotes.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val quote = mQuotes[position]
        quote.quote?.let {
            (holder as QuoteViewHolder).setQuote(it)
        }
        quote.author?.let {
            (holder as QuoteViewHolder).setAuthor(it)
        }
    }

    inner class QuoteViewHolder(val viewMvc : QuoteRowViewMVC) : RecyclerView.ViewHolder(viewMvc.getRootView()){
        fun setAuthor(text : String){
            viewMvc.setAuthor(text)
        }
        fun setQuote(text : String){
            viewMvc.setQuote(text)
        }
    }
}