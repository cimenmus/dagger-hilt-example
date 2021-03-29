package com.icmen.common.di.module

import com.icmen.common.di.annotation.BlandRetrofitQualifier
import com.icmen.common.di.annotation.DisplayOpsRetrofitQualifier
import com.icmen.common.api.BlandApiService
import com.icmen.common.api.DisplayOpsApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Suppress("unused")
@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    @Provides
    fun provideDisplayOpsApiService(@DisplayOpsRetrofitQualifier retrofit: Retrofit): DisplayOpsApiService =
        retrofit.create(DisplayOpsApiService::class.java)

    @Provides
    fun provideBlandApiService(@BlandRetrofitQualifier retrofit: Retrofit): BlandApiService =
        retrofit.create(BlandApiService::class.java)

}