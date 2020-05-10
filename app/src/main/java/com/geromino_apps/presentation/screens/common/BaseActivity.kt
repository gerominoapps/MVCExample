package com.geromino_apps.presentation.screens.common

import androidx.annotation.UiThread
import androidx.appcompat.app.AppCompatActivity
import com.geromino_apps.QuotesApplication
import com.geromino_apps.dependencyinjection.applicaiton.ApplicationComponent
import com.geromino_apps.dependencyinjection.presentation.PresentationComponent
import com.geromino_apps.dependencyinjection.presentation.PresentationModule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

abstract class BaseActivity : AppCompatActivity() {

    var mIsInjectOrUsed = false

    var jobs = listOf<Job>()

    @UiThread
    private fun getApplicationComponent(): ApplicationComponent {
        return QuotesApplication.mApplicationComponent
    }

    fun getPresentationComponent(): PresentationComponent {
        if (mIsInjectOrUsed) {
            throw RuntimeException("There is no need to inject more than once")
        }
        mIsInjectOrUsed = true
        return getApplicationComponent().newPresentationComponent(PresentationModule(this))
    }


    /**
     * To do background task with coroutines scope. It will add each job in list.
     *
     * @param code background task
     */
    fun launch(code: suspend CoroutineScope.() -> Unit) {
        jobs = jobs + CoroutineScope(Dispatchers.IO).launch(block = code)
    }
}