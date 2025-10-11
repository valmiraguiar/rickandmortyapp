package com.valmiraguiar.rickandmorty.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val _state: MutableStateFlow<HomeScreenState> = MutableStateFlow(HomeScreenState())
    val state: StateFlow<HomeScreenState> get() = _state

    fun loadData() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }

            try {
                _state.update { it.copy(characterList = mockCharacterList) }
            } catch (e: Exception) {
                _state.update { it.copy(isError = true) }
            } finally {
                _state.update { it.copy(isLoading = false) }
            }
        }
    }

    private companion object {
        val mockCharacterList: List<String> = listOf<String>(
            "Morty Smith",
            "Johnny Depp",
            "Rick Sanchez", "Morty Smith",
            "Johnny Depp",
            "Rick Sanchez", "Morty Smith",
            "Johnny Depp",
            "Rick Sanchez", "Morty Smith",
            "Johnny Depp",
            "Rick Sanchez", "Morty Smith",
            "Johnny Depp",
            "Rick Sanchez", "Morty Smith",
            "Johnny Depp",
            "Rick Sanchez", "Morty Smith",
            "Johnny Depp",
            "Rick Sanchez", "Morty Smith",
            "Johnny Depp",
            "Rick Sanchez",
        )
    }
}