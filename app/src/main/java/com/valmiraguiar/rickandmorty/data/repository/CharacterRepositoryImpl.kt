package com.valmiraguiar.rickandmorty.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.valmiraguiar.rickandmorty.data.repository.CharacterPagingSource
import com.valmiraguiar.rickandmorty.domain.entity.Character
import com.valmiraguiar.rickandmorty.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow

private const val PAGE_SIZE = 10

class CharacterRepositoryImpl(
    private val characterPagingSource: CharacterPagingSource
) : CharacterRepository {
    override fun getCharacterList(): Flow<PagingData<Character>> = Pager(
        config = PagingConfig(pageSize = PAGE_SIZE, enablePlaceholders = false),
        pagingSourceFactory = { characterPagingSource }
    ).flow
}