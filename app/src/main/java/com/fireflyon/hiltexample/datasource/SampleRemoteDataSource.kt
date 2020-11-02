package com.fireflyon.hiltexample.datasource

import com.fireflyon.hiltexample.api.BlandApiService
import com.fireflyon.hiltexample.api.DisplayOpsApiService
import com.fireflyon.hiltexample.common.SampleData
import com.fireflyon.hiltexample.utils.SampleUtils
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class SampleRemoteDataSource
@Inject constructor(private val sampleUtils: SampleUtils,
                    private val displayOpsApiService: DisplayOpsApiService,
                    private val blandApiService: BlandApiService): SampleDataSource {

    override fun getSampleData(): SampleData {
        sampleUtils.printInfo("SampleRemoteDataSource")
        return SampleData(id = "9876", name = "wxyz")
    }
}