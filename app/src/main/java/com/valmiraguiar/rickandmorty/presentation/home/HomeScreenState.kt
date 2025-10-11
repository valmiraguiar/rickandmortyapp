package com.valmiraguiar.rickandmorty.presentation.home

data class HomeScreenState(
    val characterList: List<String> = emptyList<String>(),
    val isLoading: Boolean = false,
    val isError: Boolean = false
)