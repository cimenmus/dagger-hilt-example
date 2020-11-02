package com.fireflyon.hiltexample.module

import com.fireflyon.hiltexample.BuildConfig
import com.fireflyon.hiltexample.annotation.BlandOkHttpClientQualifier
import com.fireflyon.hiltexample.annotation.DisplayOpsInterceptorQualifier
import com.fireflyon.hiltexample.annotation.DisplayOpsOkHttpClientQualifier
import com.fireflyon.hiltexample.annotation.LoggingInterceptorQualifier
import com.fireflyon.hiltexample.api.DisplayOpsRequestInterceptor
import com.fireflyon.hiltexample.api.TimeoutHeaderInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

@Module
@InstallIn(ApplicationComponent::class)
class HTTPClientModule {

    @BlandOkHttpClientQualifier
    @Provides
    fun provideBlandOkHttpClient(): OkHttpClient = OkHttpClient()

    @DisplayOpsOkHttpClientQualifier
    @Provides
    fun provideDisplayOpsOkHttpClient(builder: OkHttpClient.Builder): OkHttpClient = builder.build()

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