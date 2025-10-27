package com.valmiraguiar.rickandmorty.presentation.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.valmiraguiar.rickandmorty.domain.usecases.CharacterUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

private typealias State = DetailsScreenState

class DetailsViewModel(
    private val characterUseCase: CharacterUseCase
) : ViewModel() {
    private val _state: MutableStateFlow<State> =
        MutableStateFlow(DetailsScreenState(isLoading = true))
    val state: StateFlow<State> get() = _state

    fun getCharacter(characterId: Int) {
        viewModelScope.launch {
            characterUseCase.getCharacterDetails(characterId)
                .onStart { _state.update { it.copy(isLoading = true) } }
                .catch { e -> _state.update { it.copy(isError = true, isLoading = false) } }
                .collect { character ->
                    _state.update { it.copy(character = character, isLoading = false) }
                }
        }
    }
}