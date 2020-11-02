package com.fireflyon.hiltexample.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.fireflyon.hiltexample.common.SampleData

@Database(
    entities = [SampleData::class],
    version = 1,
    exportSchema = false
)
abstract class SampleDatabase: RoomDatabase() {
    abstract fun sampleDao(): SampleDao
}