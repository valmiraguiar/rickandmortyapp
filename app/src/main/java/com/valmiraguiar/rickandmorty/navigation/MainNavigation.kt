package com.valmiraguiar.rickandmorty.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.valmiraguiar.rickandmorty.presentation.details.DetailsScreen
import com.valmiraguiar.rickandmorty.presentation.home.HomeScreen

@Composable
fun MainNavigation(
    modifier: Modifier = Modifier
) {
    val backStack = rememberNavBackStack(Destination.Home)

    NavDisplay(
        modifier = modifier,
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<Destination.Home> {
                HomeScreen { characterId ->
                    backStack.add(Destination.Details(characterId))
                }
            }

            entry<Destination.Details> { destinationData ->
                DetailsScreen(characterId = destinationData.characterId)
            }
        }
    )
}