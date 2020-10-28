package com.fireflyon.hiltexample.repository

import com.fireflyon.hiltexample.annotation.SampleLocalDataSourceQualifier
import com.fireflyon.hiltexample.annotation.SampleRemoteDataSourceQualifier
import com.fireflyon.hiltexample.common.SampleData
import com.fireflyon.hiltexample.datasource.SampleDataSource
import com.fireflyon.hiltexample.utils.NetworkUtils
import javax.inject.Inject

class SampleRepositoryImpl
@Inject constructor(private val networkUtils: NetworkUtils,
                    @SampleRemoteDataSourceQualifier private val sampleRemoteDataSource: SampleDataSource,
                    @SampleLocalDataSourceQualifier private val sampleLocalDataSource: SampleDataSource): SampleRepository {

    override fun getSampleData(): SampleData {
        networkUtils.printInfo("Interface Implementation")
        val dataFromRemote = sampleRemoteDataSource.getSampleData()
        val dataFromLocal = sampleLocalDataSource.getSampleData()
        return dataFromRemote
    }
}