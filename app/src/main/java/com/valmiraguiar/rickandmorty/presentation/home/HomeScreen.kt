package com.valmiraguiar.rickandmorty.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.paging.compose.collectAsLazyPagingItems
import com.valmiraguiar.rickandmorty.presentation.home.components.CharacterList
import com.valmiraguiar.rickandmorty.presentation.home.components.Loading
import com.valmiraguiar.rickandmorty.presentation.home.components.TopBar
import com.valmiraguiar.rickandmorty.theme.RickAndMortyTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    vm: HomeViewModel = koinViewModel<HomeViewModel>(),
    onNavigationClick: (characterId: Int) -> Unit
) {
    val characterState by vm.state.collectAsState()
    val characterList = characterState.characterList.collectAsLazyPagingItems()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopBar(
                modifier = Modifier.statusBarsPadding()
            )
        }
    ) { innerPadding ->
        Loading(isVisible = characterState.isLoading)

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = RickAndMortyTheme.colorScheme.background)
                .padding(innerPadding)
        ) {
            CharacterList(
                characterList = characterList,
                onItemClick = onNavigationClick
            )
        }
    }
}