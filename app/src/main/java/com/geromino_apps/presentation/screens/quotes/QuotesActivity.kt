package com.geromino_apps.presentation.screens.quotes


import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.geromino_apps.domain.entities.QuoteEntity
import com.geromino_apps.domain.interactors.quote.QuotesInteractor
import com.geromino_apps.presentation.common.views.ViewMVCFactory
import com.geromino_apps.presentation.screens.common.BaseActivity
import com.geromino_apps.presentation.viewmodel.QuotesViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class QuotesActivity : BaseActivity(), QuotesViewMVC.Listener {

    @Inject
    lateinit var mViewMvcFactory: ViewMVCFactory

    @Inject
    lateinit var mQuotesInteractor : QuotesInteractor

    lateinit var mViewModel : QuotesViewModel

    private lateinit var mViewMVC : QuotesViewMVC

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = ViewModelProviders.of(this)[QuotesViewModel::class.java]
        getPresentationComponent().inject(this)
        mViewMVC = mViewMvcFactory.getQuoteViewMVC(null)
        setContentView(mViewMVC.getRootView())
        loadQuotes()
    }

    override fun onStart() {
        super.onStart()
        mViewMVC.registerListener(this)
    }

    override fun onStop() {
        super.onStop()
        mViewMVC.unRegisterListeners(this)
    }

    private fun loadQuotes(){
        mViewModel.quotes.let {
                if(it.isNotEmpty()) {
                    mViewMVC.setEmptyStateVisibility(false)
                    mViewMVC.setProgressBarVisibility(false)
                    mViewMVC.bindQuotes(it, mViewMvcFactory)
                } else {
                    loadQuotesFromDB()
                }
        }
    }

    private fun loadQuotesFromDB() {
        mViewMVC.setProgressBarVisibility(true)
        launch {
            val quotes = mQuotesInteractor.getQuotes(System.currentTimeMillis())
            withContext(Dispatchers.Main) {
                mViewMVC.setProgressBarVisibility(false)
                if(quotes.isEmpty()){
                    mViewMVC.setEmptyStateVisibility(true)
                }else {
                    mViewMVC.setEmptyStateVisibility(false)
                    mViewModel.quotes.addAll(quotes)
                    mViewMVC.bindQuotes(mViewModel.quotes, mViewMvcFactory)
                }
            }
        }
    }

    override fun onAddQuoteIsClicked(author: String, quote: String) {
        if(quote.isNotEmpty()){
            launch {
                val quoteEntity = QuoteEntity().apply {
                    this.author = if(author.isEmpty()) "Anonymous" else author
                    this.quote = "\"$quote\""
                    this.timestamp = System.currentTimeMillis()
                }
                val quoteList = ArrayList<QuoteEntity>()
                quoteList.add(quoteEntity)
                mQuotesInteractor.storeQuotes(quoteList)
                withContext(Dispatchers.Main){
                    mViewModel.quotes.add(0, quoteEntity)
                    mViewMVC.quoteAdded()
                    mViewMVC.clearAuthorEditText()
                    mViewMVC.clearQuoteEditText()
                }
            }
        }else {
            Toast.makeText(this, "Please provide a Quote", Toast.LENGTH_LONG).show()
        }
    }
}
