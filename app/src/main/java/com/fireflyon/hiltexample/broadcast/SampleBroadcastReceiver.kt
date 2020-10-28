package com.fireflyon.hiltexample.broadcast

import android.content.Intent
import com.fireflyon.hiltexample.utils.SampleUtils
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SampleBroadcastReceiver: BaseBroadCastReceiver() {

    @Inject
    lateinit var sampleUtils: SampleUtils

    override fun processBroadcast(intent: Intent) {
        sampleUtils.printInfo("Broadcast Receiver")
        networkUtils.printInfo("Broadcast Receiver")
    }
}