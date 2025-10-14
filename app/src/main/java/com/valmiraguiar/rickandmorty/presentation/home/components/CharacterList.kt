package com.valmiraguiar.rickandmorty.presentation.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.valmiraguiar.rickandmorty.domain.entity.Character
import com.valmiraguiar.rickandmorty.theme.Dimensions

private const val GRID_CELLS = 2

@Composable
fun CharacterList(
    characterList: List<Character>,
    onItemClick: () -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(GRID_CELLS),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(Dimensions.SpacingNano),
        horizontalArrangement = Arrangement.spacedBy(Dimensions.SpacingNano),
        verticalArrangement = Arrangement.spacedBy(Dimensions.SpacingNano)
    ) {
        items(characterList) { item ->
            CharacterItem(
                character = item,
                onItemClick = onItemClick
            )
        }
    }
}