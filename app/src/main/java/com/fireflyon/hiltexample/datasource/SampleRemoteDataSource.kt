package com.fireflyon.hiltexample.datasource

import com.fireflyon.hiltexample.common.SampleData
import com.fireflyon.hiltexample.utils.SampleUtils
import javax.inject.Inject

class SampleRemoteDataSource
@Inject constructor(private val sampleUtils: SampleUtils): SampleDataSource {

    override fun getSampleData(): SampleData {
        sampleUtils.printInfo("SampleRemoteDataSource")
        return SampleData(id = "9876", name = "wxyz")
    }
}