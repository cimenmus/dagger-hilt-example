package com.icmen.common.di.module

import com.icmen.common.di.annotation.*
import com.icmen.common.api.UTCAdapter
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.icmen.common.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

@Suppress("SpellCheckingInspection")
@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {

    @DisplayOpsRetrofitQualifier
    @Provides
    fun provideDisplayOpsRetrofit(@BaseUrlDisplayQualifier baseUrl: String,
                                  gsonConverterFactory: GsonConverterFactory,
                                  @DisplayOpsOkHttpClientQualifier okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(gsonConverterFactory)
            .client(okHttpClient)
            .build()
    }

    @BlandRetrofitQualifier
    @Provides
    fun provideBlandRetrofit(@BaseUrlBlandQualifier baseUrl: String,
                             gsonConverterFactory: GsonConverterFactory,
                             @BlandOkHttpClientQualifier okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(gsonConverterFactory)
            .client(okHttpClient)
            .build()
    }

    @BaseUrlDisplayQualifier
    @Provides
    fun provideDisplayBaseUrl() = "https://driverops.api.fireflyon.com"

    @BaseUrlBlandQualifier
    @Provides
    fun provideBlandBaseUrl() = "https://beta-driverops.api.fireflyon.com"

    @Provides
    fun provideGsonConverterFactory(gson: Gson): GsonConverterFactory =
        GsonConverterFactory.create(gson)

    @Provides
    fun provideGson(gsonBuilder: GsonBuilder): Gson = gsonBuilder.create()

    @Provides
    fun provideGsonBuilder(utcAdapter: UTCAdapter): GsonBuilder {
        val gsonBuilder = GsonBuilder()
            .disableHtmlEscaping()
            .serializeNulls()
            .registerTypeHierarchyAdapter(Date::class.java, utcAdapter)
        if (BuildConfig.DEBUG) {
            gsonBuilder.setPrettyPrinting()
        }
        return gsonBuilder
    }

}