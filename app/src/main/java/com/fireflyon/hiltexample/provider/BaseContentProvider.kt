package com.fireflyon.hiltexample.provider

import android.content.ContentProvider
import android.content.Context
import com.icmen.common.utils.NetworkUtils
import dagger.hilt.EntryPoint
import dagger.hilt.EntryPoints
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Inject

@InstallIn(ApplicationComponent::class)
@EntryPoint
interface BaseContentProviderEntryPoint {
    fun networkUtils(): NetworkUtils
}

abstract class BaseContentProvider: ContentProvider(){

    @Inject
    lateinit var networkUtils: NetworkUtils

    override fun onCreate(): Boolean {
        context?.let {
            makeInjections(appContext = it.applicationContext)
        } ?: run {
            throw IllegalStateException()
        }
        return true
    }

    open fun makeInjections(appContext: Context){
        networkUtils =
            EntryPoints.get(appContext, BaseContentProviderEntryPoint::class.java).networkUtils()
        /*
        networkUtils =
            EntryPointAccessors.fromApplication(appContext, BaseContentProviderEntryPoint::class.java)
                .networkUtils()
        */
    }
}