package com.geromino_apps

import android.app.Application
import com.geromino_apps.dependencyinjection.applicaiton.ApplicationComponent
import com.geromino_apps.dependencyinjection.applicaiton.ApplicationModule
import com.geromino_apps.dependencyinjection.applicaiton.DaggerApplicationComponent

class QuotesApplication : Application() {

    companion object {
        lateinit var mApplicationComponent: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        mApplicationComponent = DaggerApplicationComponent.builder().applicationModule(
            ApplicationModule(this)
        ).build()
    }
}