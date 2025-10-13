package com.valmiraguiar.rickandmorty.domain.usecases

import com.valmiraguiar.rickandmorty.domain.entity.Character
import com.valmiraguiar.rickandmorty.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow

class CharacterUseCase(
    private val repository: CharacterRepository
) {
    fun getCharacterList(): Flow<List<Character>> = repository.getCharacterList()
}