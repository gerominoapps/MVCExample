package com.geromino_apps.dependencyinjection.presentation

import com.geromino_apps.presentation.screens.quotes.QuotesActivity
import dagger.Subcomponent

@Subcomponent(modules = [PresentationModule::class])
interface PresentationComponent {
    fun inject(quotesActivity : QuotesActivity)
}