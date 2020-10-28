package com.fireflyon.hiltexample.provider

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.net.Uri
import com.fireflyon.hiltexample.utils.SampleUtils
import dagger.hilt.EntryPoint
import dagger.hilt.EntryPoints
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Inject

@InstallIn(ApplicationComponent::class)
@EntryPoint
interface SampleContentProviderEntryPoint {
    fun sampleUtils(): SampleUtils
}

class SampleContentProvider: BaseContentProvider(){

    @Inject
    lateinit var sampleUtils: SampleUtils

    override fun makeInjections(appContext: Context) {
        super.makeInjections(appContext)
        sampleUtils =
            EntryPoints.get(appContext, SampleContentProviderEntryPoint::class.java).sampleUtils()
        testInjections()
    }

    override fun query(uri: Uri,
                       projection: Array<out String>?,
                       selection: String?,
                       selectionArgs: Array<out String>?,
                       sortOrder: String?): Cursor? {
        return null
    }

    override fun getType(uri: Uri): String? {
        return null
    }

    override fun insert(uri: Uri,
                        values: ContentValues?): Uri? {
        return null
    }

    override fun delete(uri: Uri,
                        selection: String?,
                        selectionArgs: Array<out String>?): Int {
        return 0
    }

    override fun update(uri: Uri,
                        values: ContentValues?,
                        selection: String?,
                        selectionArgs: Array<out String>?): Int {
        return 0
    }

    private fun testInjections(){
        sampleUtils.printInfo("Content Provider")
        networkUtils.printInfo("Content Provider")
    }
}