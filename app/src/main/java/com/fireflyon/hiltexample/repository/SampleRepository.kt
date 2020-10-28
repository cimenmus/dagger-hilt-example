package com.fireflyon.hiltexample.repository

import com.fireflyon.hiltexample.common.SampleData

interface SampleRepository {

    fun getSampleData(): SampleData
}