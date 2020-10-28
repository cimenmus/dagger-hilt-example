package com.fireflyon.hiltexample.datasource

import com.fireflyon.hiltexample.common.SampleData

interface SampleDataSource {

    fun getSampleData(): SampleData
}