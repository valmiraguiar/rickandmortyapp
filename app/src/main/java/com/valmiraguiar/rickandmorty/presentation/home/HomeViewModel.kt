package com.valmiraguiar.rickandmorty.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.valmiraguiar.rickandmorty.domain.entity.Character
import com.valmiraguiar.rickandmorty.domain.usecases.CharacterUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

private typealias State = HomeScreenState

class HomeViewModel(
    private val characterUseCase: CharacterUseCase
) : ViewModel() {
    private val _state: MutableStateFlow<State> =
        MutableStateFlow(HomeScreenState(isLoading = true))
    val state: StateFlow<State> get() = _state

    private val _characterList: MutableStateFlow<PagingData<Character>> =
        MutableStateFlow(PagingData.empty())
    val characterList: StateFlow<PagingData<Character>> get() = _characterList

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            characterUseCase.getCharacterList().cachedIn(viewModelScope)
                .onStart {
                    _state.update { it.copy(isLoading = true) }
                }.catch { e ->
                    _state.update { it.copy(isError = true, isLoading = false) }
                }.collect { list ->
                    _characterList.update { list }
                    _state.update { it.copy(isLoading = false) }
                }
        }
    }
}