package com.valmiraguiar.rickandmorty.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.valmiraguiar.rickandmorty.domain.entity.Character
import com.valmiraguiar.rickandmorty.domain.usecases.CharacterUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val characterUseCase: CharacterUseCase
) : ViewModel() {
    private val _state: MutableStateFlow<HomeScreenState> =
        MutableStateFlow(HomeScreenState(isLoading = true))
    val state: StateFlow<HomeScreenState> get() = _state

    private val _characterList: MutableStateFlow<PagingData<Character>> =
        MutableStateFlow(PagingData.empty())
    val characterList: StateFlow<PagingData<Character>> get() = _characterList

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            characterUseCase.getCharacterList()
                .onStart {
                    _state.update { it.copy(isLoading = true) }
                }.catch { e ->
                    _state.update { it.copy(isError = true) }
                }.collect { list ->
                    _characterList.update { list }
                }.run {
                    _state.update { it.copy(isLoading = false) }
                }
        }
    }
}