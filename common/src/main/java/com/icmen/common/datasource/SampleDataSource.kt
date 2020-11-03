package com.icmen.common.datasource

import com.icmen.common.common.SampleData

interface SampleDataSource {

    suspend fun getSampleData(): SampleData

    suspend fun saveSampleData(data: SampleData)
}