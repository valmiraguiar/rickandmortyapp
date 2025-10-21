package com.valmiraguiar.rickandmorty.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.valmiraguiar.rickandmorty.domain.usecases.CharacterUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class HomeViewModel(
    private val dispatcher: CoroutineContext,
    private val characterUseCase: CharacterUseCase
) : ViewModel() {
    private val _state: MutableStateFlow<HomeScreenState> =
        MutableStateFlow(HomeScreenState(isLoading = true))
    val state: StateFlow<HomeScreenState> get() = _state

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            withContext(dispatcher) {
                _state.update { it.copy(isLoading = true) }

                try {
                    val characterListResult = characterUseCase.getCharacterList()

                    _state.update {
                        it.copy(
                            characterList = characterListResult
                        )
                    }
                } catch (e: Exception) {
                    _state.update { it.copy(isError = true) }
                } finally {
                    _state.update { it.copy(isLoading = false) }
                }
            }
        }
    }
}