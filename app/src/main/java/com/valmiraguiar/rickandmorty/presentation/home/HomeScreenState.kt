package com.valmiraguiar.rickandmorty.presentation.home

import androidx.paging.PagingData
import com.valmiraguiar.rickandmorty.domain.entity.Character
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

data class HomeScreenState(
    val characterList: Flow<PagingData<Character>> = flowOf(PagingData.empty()),
    val isLoading: Boolean = false,
    val isError: Boolean = false
)