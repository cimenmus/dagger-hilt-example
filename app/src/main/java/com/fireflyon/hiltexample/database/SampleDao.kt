package com.fireflyon.hiltexample.database

import androidx.room.*
import com.fireflyon.hiltexample.common.SampleData

@Dao
interface SampleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun add(data: SampleData): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun add(data: List<SampleData>): List<Long>

    @Query("SELECT * FROM SampleData")
    fun getAll(): List<SampleData>
}