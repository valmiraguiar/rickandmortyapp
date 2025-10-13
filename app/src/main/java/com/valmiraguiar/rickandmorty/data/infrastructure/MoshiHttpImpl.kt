package com.valmiraguiar.rickandmorty.data.infrastructure

import retrofit2.Retrofit

class MoshiHttpImpl(
    private val retrofit: Retrofit
) : MoshiHttp {
    override fun getHttpConfig(): Retrofit = retrofit
}