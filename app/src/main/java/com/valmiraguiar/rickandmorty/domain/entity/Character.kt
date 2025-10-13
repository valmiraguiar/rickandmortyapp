package com.valmiraguiar.rickandmorty.domain.entity

data class Character(
    val id: Int,
    val name: String,
    val status: String,
    val specie: String,
    val type: String,
    val gender: String,
    val origin: String,
    val location: String,
    val image: String,
)