package com.geromino_apps.dependencyinjection.applicaiton

import android.app.Application
import androidx.room.Room
import com.geromino_apps.data.roomdb.db.AppDataBase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(application: Application) {

    private val mApplication = application

    @Provides
    fun getApplication(): Application {
        return mApplication
    }

    @Singleton
    @Provides
    fun getRoomDB(): AppDataBase {
        return Room.databaseBuilder(
            mApplication,
            AppDataBase::class.java, "quotes-example"
        ).build()
    }


}