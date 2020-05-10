package com.geromino_apps.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.geromino_apps.domain.entities.QuoteEntity

class QuotesViewModel : ViewModel(){

    var quotes : ArrayList<QuoteEntity> = ArrayList()
}