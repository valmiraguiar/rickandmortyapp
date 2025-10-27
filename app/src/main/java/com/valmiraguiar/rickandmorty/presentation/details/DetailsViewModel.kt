package com.valmiraguiar.rickandmorty.presentation.details

import androidx.lifecycle.ViewModel
import com.valmiraguiar.rickandmorty.domain.entity.Character

class DetailsViewModel: ViewModel() {
    fun getCharacter(characterId: Int): Character {
        return MOCK_CHARACTER
    }

    private companion object {
        val MOCK_CHARACTER = Character(
            id = 1,
            name = "Rick Sanchez",
            status = "Alive",
            specie = "Human",
            type = "Human with antennae",
            gender = "Male",
            origin = "Earth (C-137)",
            location = "Citadel of Ricks",
            image = "https://rickandmortyapi.com/api/character/avatar/7.jpeg",
        )
    }
}