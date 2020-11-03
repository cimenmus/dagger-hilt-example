package com.icmen.common.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.icmen.common.common.SampleData

@Database(
    entities = [SampleData::class],
    version = 1,
    exportSchema = false
)
abstract class SampleDatabase: RoomDatabase() {
    abstract fun sampleDao(): SampleDao
}