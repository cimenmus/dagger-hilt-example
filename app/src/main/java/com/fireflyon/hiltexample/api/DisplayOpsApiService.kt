package com.fireflyon.hiltexample.api

import retrofit2.http.GET
import retrofit2.http.Path

interface DisplayOpsApiService {

    @GET("fireplay-version/{imei}")
    suspend fun checkDeviceCreated(@Path("imei") imei: String): String
}