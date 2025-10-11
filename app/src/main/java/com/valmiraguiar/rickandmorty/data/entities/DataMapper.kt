package com.valmiraguiar.rickandmorty.data.entities

interface DataMapper<DTO, MODEL> {
    fun convert(dtoData: DTO): MODEL
}