package com.valmiraguiar.rickandmorty.data.mapper

import com.valmiraguiar.rickandmorty.data.entities.CharacterResponse
import com.valmiraguiar.rickandmorty.domain.entity.Character

class CharacterMapperImpl : CharacterMapper {
    override fun convert(dtoData: CharacterResponse): Character = with(dtoData) {
        return Character(
            id = this.id ?: 0,
            name = this.name ?: "",
            status = this.status ?: "",
            specie = this.specie ?: "",
            type = this.type ?: "",
            gender = this.gender ?: "",
            origin = this.origin?.locationName ?: "",
            location = this.location?.locationName ?: "",
            image = this.image ?: ""
        )
    }
}