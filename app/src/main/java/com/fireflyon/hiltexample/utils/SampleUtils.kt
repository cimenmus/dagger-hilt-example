package com.fireflyon.hiltexample.utils

import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SampleUtils @Inject constructor(){

    fun printInfo(message: String) =
        Log.i("mstf", "injection succeed in $message")
}