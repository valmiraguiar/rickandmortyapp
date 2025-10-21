package com.valmiraguiar.rickandmorty.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed interface Destination : NavKey {
    @Serializable
    data object Home : Destination

    @Serializable
    data class Details(val characterId: Int) : Destination
}