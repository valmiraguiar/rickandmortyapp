package com.valmiraguiar.rickandmorty.presentation.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.valmiraguiar.rickandmorty.theme.AppTheme
import com.valmiraguiar.rickandmorty.theme.Dimensions
import com.valmiraguiar.rickandmorty.theme.Gray200
import com.valmiraguiar.rickandmorty.theme.RickAndMortyTheme

@Composable
fun CharacterItem(
    characterName: String,
    onItemClick: () -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .clickable {
                onItemClick()
            },

        ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = characterName, style = RickAndMortyTheme.typography.titleLarge)
                    Text(text = "Human", style = RickAndMortyTheme.typography.labelSmall)
                }

                Text("Earth (Replacement Dimension)", style = RickAndMortyTheme.typography.body)

                HorizontalDivider(
                    color = Gray200
                )

                Row(
                    horizontalArrangement = Arrangement.spacedBy(Dimensions.SpacingNano)
                ) {
                    Text("Male", style = RickAndMortyTheme.typography.body)
                    Text("Alive", style = RickAndMortyTheme.typography.body)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CharacterItemPreview() {
    AppTheme {
        CharacterItem("Rick Sanchez") {
            println("")
        }
    }
}