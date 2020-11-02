package com.fireflyon.hiltexample.datasource

import com.fireflyon.hiltexample.common.SampleData

interface SampleDataSource {

    suspend fun getSampleData(): SampleData

    suspend fun saveSampleData(data: SampleData)
}