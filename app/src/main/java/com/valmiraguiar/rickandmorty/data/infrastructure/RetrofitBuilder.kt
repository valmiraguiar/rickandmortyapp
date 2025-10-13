package com.valmiraguiar.rickandmorty.data.infrastructure

import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RetrofitBuilder(
    private val baseUrl: String,
    private val client: OkHttpClient
) {
    fun build(): Retrofit {
        fun moshiProvider() = Moshi.Builder().build()

        return Retrofit
            .Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(
                MoshiConverterFactory.create(moshiProvider())
            )
            .build()
    }
}