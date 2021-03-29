package com.icmen.common.di.module

import com.icmen.common.repository.SampleRepository
import com.icmen.common.repository.SampleRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindSampleRepository(sampleRepositoryImpl: SampleRepositoryImpl): SampleRepository
}