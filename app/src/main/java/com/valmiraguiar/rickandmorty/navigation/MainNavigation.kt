package com.valmiraguiar.rickandmorty.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.valmiraguiar.rickandmorty.presentation.details.DetailsScreen
import com.valmiraguiar.rickandmorty.presentation.home.HomeScreen

@Composable
fun MainNavigation () {
    val backStack = rememberNavBackStack(Destination.Home)

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        NavDisplay(
            modifier = Modifier.padding(innerPadding),
            backStack = backStack,
            onBack = {backStack.removeLastOrNull()},
            entryProvider = entryProvider {
                entry<Destination.Home> {
                    HomeScreen {
                        backStack.add(Destination.Details)
                    }
                }

                entry<Destination.Details> {
                    DetailsScreen()
                }
            }
        )
    }
}