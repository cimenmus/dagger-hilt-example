package com.icmen.common.di.module

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.icmen.common.database.SampleDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    fun provideSampleDao(sampleDatabase: SampleDatabase) = sampleDatabase.sampleDao()

    @Provides
    fun provideSampleDatabase(sampleDatabaseBuilder: RoomDatabase.Builder<SampleDatabase?>) =
        sampleDatabaseBuilder.fallbackToDestructiveMigration().build()

    @Provides
    fun provideSampleDatabaseBuilder(@ApplicationContext context: Context?) =
        Room.databaseBuilder(
            context!!,
            SampleDatabase::class.java,
            "sample.db")
}