package com.fireflyon.hiltexample.app

import android.app.Application
import com.fireflyon.hiltexample.utils.SampleUtils
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class App: Application() {

    @Inject
    lateinit var sampleUtils: SampleUtils

    override fun onCreate() {
        super.onCreate()
        print(sampleUtils.printInfo("Application class"))
    }
}