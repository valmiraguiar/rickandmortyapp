package com.valmiraguiar.rickandmorty.data.mapper

import com.valmiraguiar.rickandmorty.data.entities.CharacterResponse
import com.valmiraguiar.rickandmorty.domain.entity.Character

class CharacterListMapperImpl : CharacterListMapper {
    override fun convert(dtoData: List<CharacterResponse>): List<Character> = with(dtoData) {
        return this.map {
            Character(
                id = it.id ?: 0,
                name = it.name ?: "",
                status = it.status ?: "",
                specie = it.specie ?: "",
                type = it.type ?: "",
                gender = it.gender ?: "",
                origin = it.origin?.locationName ?: "",
                location = it.location?.locationName ?: "",
                image = it.image ?: ""
            )
        }
    }
}