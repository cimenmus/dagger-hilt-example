package com.icmen.common.repository

import com.icmen.common.common.SampleData

interface SampleRepository {

    suspend fun getSampleData(): SampleData

    suspend fun saveSampleData(data: SampleData)
}