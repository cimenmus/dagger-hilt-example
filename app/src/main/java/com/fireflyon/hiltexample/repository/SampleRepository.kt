package com.fireflyon.hiltexample.repository

import com.fireflyon.hiltexample.common.SampleData

interface SampleRepository {

    suspend fun getSampleData(): SampleData

    suspend fun saveSampleData(data: SampleData)
}