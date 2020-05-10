package com.geromino_apps.dependencyinjection.presentation

import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.geromino_apps.presentation.common.views.ViewMVCFactory
import dagger.Module
import dagger.Provides

@Module
class PresentationModule (appCompatActivity: AppCompatActivity){

    private val mActivity: AppCompatActivity = appCompatActivity

    @Provides
    fun getFragmentManager(): FragmentManager {
        return mActivity.supportFragmentManager
    }

    @Provides
    fun getLayoutInflater(): LayoutInflater {
        return LayoutInflater.from(mActivity)
    }

    @Provides
    fun getViewMVCFactory(inflater: LayoutInflater): ViewMVCFactory {
        return ViewMVCFactory(inflater)
    }
}