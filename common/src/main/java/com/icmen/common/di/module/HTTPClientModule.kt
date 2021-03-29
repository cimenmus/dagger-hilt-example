package com.icmen.common.di.module

import com.icmen.common.BuildConfig
import com.icmen.common.di.annotation.BlandOkHttpClientQualifier
import com.icmen.common.di.annotation.DisplayOpsInterceptorQualifier
import com.icmen.common.di.annotation.DisplayOpsOkHttpClientQualifier
import com.icmen.common.di.annotation.LoggingInterceptorQualifier
import com.icmen.common.api.DisplayOpsRequestInterceptor
import com.icmen.common.api.TimeoutHeaderInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
class HTTPClientModule {

    @BlandOkHttpClientQualifier
    @Provides
    fun provideBlandOkHttpClient(): OkHttpClient = OkHttpClient()

    @DisplayOpsOkHttpClientQualifier
    @Provides
    fun provideDisplayOpsOkHttpClient(builder: OkHttpClient.Builder): OkHttpClient {
        return builder.build()
    }

    @Provides
    fun provideDisplayOpsOkHttpBuilder(@DisplayOpsInterceptorQualifier requestInterceptor: Interceptor,
                                       @LoggingInterceptorQualifier loggingInterceptor: Interceptor,
                                       timeoutHeaderInterceptor: Interceptor,
                                       timeout: Int): OkHttpClient.Builder {
        val builder =
            OkHttpClient.Builder()
                .connectTimeout(timeout.toLong(), TimeUnit.SECONDS)
                .readTimeout(timeout.toLong(), TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .addInterceptor(requestInterceptor)
                .addInterceptor(timeoutHeaderInterceptor)
                .followRedirects(true)
        if (BuildConfig.DEBUG) {
            builder.addInterceptor(loggingInterceptor)
        }
        return builder
    }

    @Provides
    @DisplayOpsInterceptorQualifier
    fun provideDisplayOpsRequestInterceptor(): Interceptor = DisplayOpsRequestInterceptor()

    @Provides
    @LoggingInterceptorQualifier
    fun provideLoggingInterceptor(): Interceptor =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides
    fun provideTimeoutHeaderInterceptor(): Interceptor = TimeoutHeaderInterceptor()

    @Provides
    fun provideTimeout() = 15
}