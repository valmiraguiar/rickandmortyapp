package com.valmiraguiar.rickandmorty.data.infrastructure

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

class OkHttpBuilder {
    fun build(): OkHttpClient {
        return OkHttpClient
            .Builder()
            .addInterceptor(
                okHttpLoggingInterceptor()
            ).build()
    }

    private fun okHttpLoggingInterceptor() = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
}