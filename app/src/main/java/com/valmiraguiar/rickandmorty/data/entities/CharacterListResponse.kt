package com.valmiraguiar.rickandmorty.data.entities

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CharacterListResponse(
    @field:Json(name = "info") val info: InfoResponse? = null,
    @field:Json(name = "results") val results: List<CharacterResponse>? = null,
)

@JsonClass(generateAdapter = true)
data class InfoResponse(
    @field:Json(name = "count") val count: Int? = null,
    @field:Json(name = "pages") val pages: Int? = null,
    @field:Json(name = "next") val next: String? = null,
    @field:Json(name = "prev") val prev: String? = null,
)

