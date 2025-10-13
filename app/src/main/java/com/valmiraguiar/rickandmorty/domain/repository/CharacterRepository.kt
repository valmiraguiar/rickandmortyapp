package com.valmiraguiar.rickandmorty.domain.repository

import com.valmiraguiar.rickandmorty.domain.entity.Character
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    fun getCharacterList(): Flow<List<Character>>
}