package com.valmiraguiar.rickandmorty.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.valmiraguiar.rickandmorty.presentation.home.components.CharacterItem
import com.valmiraguiar.rickandmorty.presentation.home.components.TopBar
import com.valmiraguiar.rickandmorty.theme.RickAndMortyTheme

@Composable
fun HomeScreen(
    onNavigationClick: () -> Unit
) {
    val list = listOf<String>(
        "Morty Smith",
        "Johnny Depp",
        "Rick Sanchez","Morty Smith",
        "Johnny Depp",
        "Rick Sanchez","Morty Smith",
        "Johnny Depp",
        "Rick Sanchez","Morty Smith",
        "Johnny Depp",
        "Rick Sanchez","Morty Smith",
        "Johnny Depp",
        "Rick Sanchez","Morty Smith",
        "Johnny Depp",
        "Rick Sanchez","Morty Smith",
        "Johnny Depp",
        "Rick Sanchez", "Morty Smith",
        "Johnny Depp",
        "Rick Sanchez",
    )

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { TopBar(
            modifier = Modifier.statusBarsPadding()
        ) }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = RickAndMortyTheme.colorScheme.background)
                .padding(innerPadding)
        ) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(list) { item ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(color = Color.Red)
                            .clickable { onNavigationClick() },
                        contentAlignment = Alignment.Center,
                    ) {
                        CharacterItem(item)
                    }
                }
            }
        }
    }
}