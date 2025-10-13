package com.valmiraguiar.rickandmorty.data.mapper

import com.valmiraguiar.rickandmorty.data.entities.ResultResponse
import com.valmiraguiar.rickandmorty.domain.entity.Character

class CharacterMapperImpl : CharacterMapper {
    override fun convert(dtoData: List<ResultResponse>): List<Character> = with(dtoData) {
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