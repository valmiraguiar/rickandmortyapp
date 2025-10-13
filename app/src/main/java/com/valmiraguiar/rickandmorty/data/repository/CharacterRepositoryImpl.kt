package com.valmiraguiar.rickandmorty.data.repository

import com.valmiraguiar.rickandmorty.data.mapper.CharacterMapper
import com.valmiraguiar.rickandmorty.data.remote.RickAndMortyApi
import com.valmiraguiar.rickandmorty.domain.entity.Character
import com.valmiraguiar.rickandmorty.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CharacterRepositoryImpl(
    private val api: RickAndMortyApi,
    private val mapper: CharacterMapper
) : CharacterRepository {
    override fun getCharacterList(): Flow<List<Character>> = flow {
        try {
            val response = requireNotNull(api.getCharacters().body()?.results)
            emit(mapper.convert(response))
        } catch (e: Exception) {
            throw e
        }
    }
}