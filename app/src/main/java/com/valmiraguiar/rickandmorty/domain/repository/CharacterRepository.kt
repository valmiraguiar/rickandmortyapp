package com.valmiraguiar.rickandmorty.domain.repository

import androidx.paging.PagingData
import com.valmiraguiar.rickandmorty.domain.entity.Character
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    fun getCharacterList(): Flow<PagingData<Character>>
    fun getCharacter(id: Int): Flow<Character>
}