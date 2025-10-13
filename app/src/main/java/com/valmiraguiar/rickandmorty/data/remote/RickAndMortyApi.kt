package com.valmiraguiar.rickandmorty.data.remote

import com.valmiraguiar.rickandmorty.data.entities.CharacterResponse
import retrofit2.Response
import retrofit2.http.GET

interface RickAndMortyApi {
    @GET("/api/character")
    suspend fun getCharacters(): Response<CharacterResponse>
}