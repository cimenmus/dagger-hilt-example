package com.fireflyon.hiltexample.service

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import com.fireflyon.hiltexample.utils.NetworkUtils
import kotlinx.coroutines.*
import javax.inject.Inject

@Suppress("SpellCheckingInspection")
abstract class BaseService: Service() {

    @Inject
    lateinit var networkUtils: NetworkUtils

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        serviceLogic()
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent?): IBinder? {
        serviceLogic()
        return BaseServiceBinder()
    }

    abstract fun serviceLogic()

    // Service Binder Inner-class!
    inner class BaseServiceBinder : Binder() {
        fun getService(): BaseService? {
            return this@BaseService
        }
    }

}