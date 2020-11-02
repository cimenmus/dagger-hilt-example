package com.fireflyon.hiltexample.module

import com.fireflyon.hiltexample.annotation.BlandRetrofitQualifier
import com.fireflyon.hiltexample.annotation.DisplayOpsRetrofitQualifier
import com.fireflyon.hiltexample.api.BlandApiService
import com.fireflyon.hiltexample.api.DisplayOpsApiService
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