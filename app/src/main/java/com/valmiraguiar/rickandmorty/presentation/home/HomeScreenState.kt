package com.valmiraguiar.rickandmorty.presentation.home

import com.valmiraguiar.rickandmorty.domain.entity.Character

data class HomeScreenState(
    val characterList: List<Character> = emptyList(),
    val isLoading: Boolean = false,
    val isError: Boolean = false
)