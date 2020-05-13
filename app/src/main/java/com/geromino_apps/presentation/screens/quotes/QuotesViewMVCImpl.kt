package com.geromino_apps.presentation.screens.quotes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.annotation.Nullable
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.geromino_apps.R
import com.geromino_apps.domain.entities.QuoteEntity
import com.geromino_apps.presentation.common.views.BaseObservableViewMvc
import com.geromino_apps.presentation.common.views.ViewMVCFactory
import com.geromino_apps.presentation.screens.quotes.adapter.QuotesAdapter

class QuotesViewMVCImpl(inflater: LayoutInflater, @Nullable parent: ViewGroup?) : BaseObservableViewMvc<QuotesViewMVC.Listener>() , QuotesViewMVC{

    val mAuthorEt : AppCompatEditText
    val mQuotesEt : AppCompatEditText
    val mAddQuoteBtn : AppCompatButton
    val mProgressBar : ProgressBar
    val mEmptyStateMessage : AppCompatTextView
    val mRv : RecyclerView
    val mLinearLayoutManager : LinearLayoutManager
    var mAdapter : QuotesAdapter? = null

    init {
        setRootView(inflater.inflate(R.layout.activity_quotes, parent, false))
        mAuthorEt = findViewById(R.id.author_et)
        mQuotesEt = findViewById(R.id.quote_et)
        mAddQuoteBtn = findViewById(R.id.add_quote_btn)
        mProgressBar = findViewById(R.id.pb)
        mEmptyStateMessage = findViewById(R.id.empty_state_tv)
        mAddQuoteBtn.setOnClickListener {
            for(listener in mListeners){
                listener.onAddQuoteIsClicked(mAuthorEt.text.toString() , mQuotesEt.text.toString())
            }
        }
        mRv = findViewById(R.id.quotes_rv)
        mLinearLayoutManager = LinearLayoutManager(mRv.context)
        mRv.setHasFixedSize(false)
        mRv.layoutManager = mLinearLayoutManager
    }

    override fun clearQuoteEditText() {
        mQuotesEt.setText("")
    }

    override fun clearAuthorEditText() {
        mAuthorEt.setText("")
    }

    override fun bindQuotes(quotes: List<QuoteEntity>, viewFactory : ViewMVCFactory) {
        mAdapter = QuotesAdapter(quotes, viewFactory)
        mRv.adapter = mAdapter
    }

    override fun quoteAdded() {
        mRv.scrollToPosition(0)
        if(mAdapter?.itemCount == 0){
            mAdapter?.notifyDataSetChanged()
        } else {
            mAdapter?.notifyItemInserted(0)
        }
    }

    override fun setProgressBarVisibility(isVisible: Boolean) {
        mProgressBar.visibility  = if(isVisible) View.VISIBLE else View.INVISIBLE
    }

    override fun setEmptyStateVisibility(isVisible: Boolean) {
        mEmptyStateMessage.visibility  = if(isVisible) View.VISIBLE else View.INVISIBLE
    }

    override fun isAdapterIsEmpty(): Boolean {
        return mAdapter?.let { it.itemCount > 0}?:true
    }
}