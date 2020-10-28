package com.fireflyon.hiltexample.datasource

import com.fireflyon.hiltexample.common.SampleData
import com.fireflyon.hiltexample.utils.SampleUtils
import javax.inject.Inject

class SampleLocalDataSource
@Inject constructor(private val sampleUtils: SampleUtils): SampleDataSource {

    override fun getSampleData(): SampleData {
        sampleUtils.printInfo("SampleLocalDataSource")
        return SampleData(id = "1234", name = "abcd")
    }
}