package com.valmiraguiar.rickandmorty.data.remote

import com.valmiraguiar.rickandmorty.data.entities.CharacterListResponse
import com.valmiraguiar.rickandmorty.data.entities.CharacterResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickAndMortyApi {
    @GET("/api/character")
    suspend fun getCharacters(@Query("page") page: Int?): Response<CharacterListResponse>

    @GET("/api/character/{id}")
    suspend fun getCharacter(@Path("id") id: Int): Response<CharacterResponse>
}