package com.valmiraguiar.rickandmorty.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.valmiraguiar.rickandmorty.presentation.home.components.CharacterList
import com.valmiraguiar.rickandmorty.presentation.home.components.TopBar
import com.valmiraguiar.rickandmorty.theme.RickAndMortyTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    onNavigationClick: () -> Unit
) {
    val vm = koinViewModel<HomeViewModel>()
    val characterState = vm.state.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        vm.loadData()
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopBar(
                modifier = Modifier.statusBarsPadding()
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = RickAndMortyTheme.colorScheme.background)
                .padding(innerPadding)
        ) {
            CharacterList(
                characterList = characterState.value.characterList,
                onItemClick = onNavigationClick
            )
        }
    }
}