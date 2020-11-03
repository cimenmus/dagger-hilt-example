package com.icmen.common.datasource

import com.icmen.common.api.BlandApiService
import com.icmen.common.api.DisplayOpsApiService
import com.icmen.common.common.SampleData
import com.icmen.common.utils.SampleUtils
import java.lang.UnsupportedOperationException
import java.util.*
import javax.inject.Inject

class SampleRemoteDataSource
@Inject constructor(private val sampleUtils: SampleUtils,
                    private val displayOpsApiService: DisplayOpsApiService,
                    private val blandApiService: BlandApiService): SampleDataSource {

    override suspend fun getSampleData(): SampleData {
        sampleUtils.printInfo("SampleRemoteDataSource")
        val id = UUID.randomUUID().toString()
        val name = (0..100000).random().toString()
        return SampleData(id = id, name = name)
    }

    override suspend fun saveSampleData(data: SampleData) = throw UnsupportedOperationException()
}