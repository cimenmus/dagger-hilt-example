package com.icmen.common.api

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class DisplayOpsRequestInterceptor constructor(): Interceptor {

    companion object {
        private const val CONTENT_TYPE = "application/json"
    }

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val newRequestBuilder = original.newBuilder()
        newRequestBuilder.addHeader("Content-Type", CONTENT_TYPE)
        return chain.proceed(newRequestBuilder.build())
    }

}