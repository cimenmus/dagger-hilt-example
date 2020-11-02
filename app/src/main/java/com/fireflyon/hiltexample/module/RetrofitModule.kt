package com.fireflyon.hiltexample.module

import com.fireflyon.hiltexample.BuildConfig
import com.fireflyon.hiltexample.annotation.BlandOkHttpClientQualifier
import com.fireflyon.hiltexample.annotation.BlandRetrofitQualifier
import com.fireflyon.hiltexample.annotation.DisplayOpsOkHttpClientQualifier
import com.fireflyon.hiltexample.annotation.DisplayOpsRetrofitQualifier
import com.fireflyon.hiltexample.api.UTCAdapter
import com.google.gson.Gson
import com.google.gson.GsonBuilder
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
    fun provideDisplayOpsRetrofit(gsonConverterFactory: GsonConverterFactory,
                                  @DisplayOpsOkHttpClientQualifier okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://beta-driverops.api.fireflyon.com")
            .addConverterFactory(gsonConverterFactory)
            .client(okHttpClient)
            .build()
    }

    @BlandRetrofitQualifier
    @Provides
    fun provideBlandRetrofit(gsonConverterFactory: GsonConverterFactory,
                               @BlandOkHttpClientQualifier okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://beta-driverops.api.fireflyon.com")
            .addConverterFactory(gsonConverterFactory)
            .client(okHttpClient)
            .build()
    }

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