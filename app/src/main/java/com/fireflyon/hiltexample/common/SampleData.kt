package com.fireflyon.hiltexample.common

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SampleData(

    @PrimaryKey
    val id: String = "",

    val name: String = "")
