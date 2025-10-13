package com.valmiraguiar.rickandmorty.data.entities

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CharacterResponse(
    @field:Json(name = "info") val info: InfoResponse? = null,
    @field:Json(name = "results") val results: List<ResultResponse>? = null,
)

@JsonClass(generateAdapter = true)
data class InfoResponse(
    @field:Json(name = "count") val count: Int? = null,
    @field:Json(name = "pages") val pages: Int? = null,
    @field:Json(name = "next") val next: String? = null,
    @field:Json(name = "prev") val prev: String? = null,
)

@JsonClass(generateAdapter = true)
data class ResultResponse(
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