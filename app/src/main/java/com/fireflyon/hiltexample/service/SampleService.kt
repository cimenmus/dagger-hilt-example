package com.fireflyon.hiltexample.service

import com.fireflyon.hiltexample.utils.SampleUtils
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SampleService: BaseService() {

    @Inject
    lateinit var sampleUtils: SampleUtils

    override fun serviceLogic() {
        sampleUtils.printInfo("Service")
        networkUtils.printInfo("Service")
    }

}