package com.valmiraguiar.rickandmorty.data.entities

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CharacterResponse(
    @field:Json(name = "id") val id: Int? = null,
    @field:Json(name = "name") val name: String? = null,
    @field:Json(name = "status") val status: String? = null,
    @field:Json(name = "species") val specie: String? = null,
    @field:Json(name = "type") val type: String? = null,
    @field:Json(name = "gender") val gender: String? = null,
    @field:Json(name = "origin") val origin: LocationResponse? = null,
    @field:Json(name = "location") val location: LocationResponse? = null,
    @field:Json(name = "image") val image: String? = null,
)

@JsonClass(generateAdapter = true)
data class LocationResponse(
    @field:Json(name = "name") val locationName: String? = null,
    @field:Json(name = "url") val locationUrl: String? = null,
)