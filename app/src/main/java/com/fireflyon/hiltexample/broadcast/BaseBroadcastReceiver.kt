package com.fireflyon.hiltexample.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.fireflyon.hiltexample.utils.NetworkUtils
import javax.inject.Inject

abstract class BaseBroadCastReceiver: BroadcastReceiver() {

    @Inject
    lateinit var networkUtils: NetworkUtils

    override fun onReceive(context: Context?, intent: Intent?) {
        intent?.let {
            processBroadcast(intent = it)
        }
    }

    abstract fun processBroadcast(intent: Intent)
}