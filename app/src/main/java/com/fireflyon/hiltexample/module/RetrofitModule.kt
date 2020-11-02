package com.fireflyon.hiltexample.module

import android.content.Context
import com.fireflyon.hiltexample.BuildConfig
import com.fireflyon.hiltexample.R
import com.fireflyon.hiltexample.annotation.*
import com.fireflyon.hiltexample.api.UTCAdapter
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext
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
    fun provideDisplayBaseUrl(@ApplicationContext context: Context) =
        context.getString(R.string.base_url_display)

    @BaseUrlBlandQualifier
    @Provides
    fun provideBlandBaseUrl(@ApplicationContext context: Context) =
        context.getString(R.string.base_url_bland)

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