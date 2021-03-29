package com.icmen.common.di.module

import com.icmen.common.di.annotation.SampleLocalDataSourceQualifier
import com.icmen.common.di.annotation.SampleRemoteDataSourceQualifier
import com.icmen.common.datasource.SampleDataSource
import com.icmen.common.datasource.SampleLocalDataSource
import com.icmen.common.datasource.SampleRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    @SampleRemoteDataSourceQualifier
    abstract fun bindSampleRemoteData(sampleRemoteDataSource: SampleRemoteDataSource): SampleDataSource

    @Binds
    @SampleLocalDataSourceQualifier
    abstract fun bindSampleLocalData(sampleLocalDataSource: SampleLocalDataSource): SampleDataSource
}