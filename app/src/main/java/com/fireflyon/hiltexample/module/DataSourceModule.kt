package com.fireflyon.hiltexample.module

import com.fireflyon.hiltexample.annotation.SampleLocalDataSourceQualifier
import com.fireflyon.hiltexample.annotation.SampleRemoteDataSourceQualifier
import com.fireflyon.hiltexample.datasource.SampleDataSource
import com.fireflyon.hiltexample.datasource.SampleLocalDataSource
import com.fireflyon.hiltexample.datasource.SampleRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
abstract class DataSourceModule {

    @Binds
    @SampleRemoteDataSourceQualifier
    abstract fun bindSampleRemoteData(sampleRemoteDataSource: SampleRemoteDataSource): SampleDataSource

    @Binds
    @SampleLocalDataSourceQualifier
    abstract fun bindSampleLocalData(sampleLocalDataSource: SampleLocalDataSource): SampleDataSource
}