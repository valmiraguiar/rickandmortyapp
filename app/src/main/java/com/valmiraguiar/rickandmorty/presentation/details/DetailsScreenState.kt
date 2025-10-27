package com.valmiraguiar.rickandmorty.presentation.details

import com.valmiraguiar.rickandmorty.domain.entity.Character

data class DetailsScreenState (
    val character: Character? = null,
    val isLoading: Boolean = false,
    val isError: Boolean = false
)