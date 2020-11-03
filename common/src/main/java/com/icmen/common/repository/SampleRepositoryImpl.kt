package com.icmen.common.repository

import com.icmen.common.di.annotation.SampleLocalDataSourceQualifier
import com.icmen.common.di.annotation.SampleRemoteDataSourceQualifier
import com.icmen.common.datasource.SampleDataSource
import com.icmen.common.common.SampleData
import com.icmen.common.utils.NetworkUtils
import javax.inject.Inject

class SampleRepositoryImpl
@Inject constructor(private val networkUtils: NetworkUtils,
                    @SampleRemoteDataSourceQualifier private val sampleRemoteDataSource: SampleDataSource,
                    @SampleLocalDataSourceQualifier private val sampleLocalDataSource: SampleDataSource): SampleRepository {

    override suspend fun getSampleData(): SampleData {
        networkUtils.printInfo("Interface Implementation")
        val dataFromRemote = sampleRemoteDataSource.getSampleData()
        saveSampleData(data = dataFromRemote)
        val dataFromLocal = sampleLocalDataSource.getSampleData()
        return dataFromLocal
    }

    override suspend fun saveSampleData(data: SampleData) = sampleLocalDataSource.saveSampleData(data)
}