package com.fireflyon.hiltexample.utils

import android.util.Log
import javax.inject.Inject

class NetworkUtils @Inject constructor(){

    fun printInfo(message: String) =
        Log.i("mstf", "injection succeed in $message")
}