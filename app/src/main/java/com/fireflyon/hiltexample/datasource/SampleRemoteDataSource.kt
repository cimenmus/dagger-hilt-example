package com.fireflyon.hiltexample.datasource

import com.fireflyon.hiltexample.api.BlandApiService
import com.fireflyon.hiltexample.api.DisplayOpsApiService
import com.fireflyon.hiltexample.common.SampleData
import com.fireflyon.hiltexample.utils.SampleUtils
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.UnsupportedOperationException
import java.util.*
import javax.inject.Inject
import kotlin.random.Random

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