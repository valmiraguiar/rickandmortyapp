package com.valmiraguiar.rickandmorty.domain.usecases

import androidx.paging.PagingData
import com.valmiraguiar.rickandmorty.domain.entity.Character
import com.valmiraguiar.rickandmorty.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow

class CharacterUseCase(
    private val repository: CharacterRepository
) {
    fun getCharacterList(): Flow<PagingData<Character>> = repository.getCharacterList()
    fun getCharacterDetails(id: Int): Flow<Character> = repository.getCharacter(id)
}