package com.fireflyon.hiltexample.module

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.fireflyon.hiltexample.database.SampleDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ApplicationComponent::class)
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