package com.valmiraguiar.rickandmorty.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.valmiraguiar.rickandmorty.data.mapper.CharacterMapper
import com.valmiraguiar.rickandmorty.data.remote.RickAndMortyApi
import com.valmiraguiar.rickandmorty.domain.entity.Character
import com.valmiraguiar.rickandmorty.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

private const val PAGE_SIZE = 10

class CharacterRepositoryImpl(
    private val api: RickAndMortyApi,
    private val characterPagingSource: CharacterPagingSource,
    private val mapper: CharacterMapper
) : CharacterRepository {
    override fun getCharacterList(): Flow<PagingData<Character>> = Pager(
        config = PagingConfig(pageSize = PAGE_SIZE, enablePlaceholders = false),
        pagingSourceFactory = { characterPagingSource }
    ).flow

    override fun getCharacter(id: Int): Flow<Character> = flow {
        try {
            val response = requireNotNull(api.getCharacter(id).body())
            emit(mapper.convert(response))
        } catch (e: Exception) {
            throw e
        }
    }
}