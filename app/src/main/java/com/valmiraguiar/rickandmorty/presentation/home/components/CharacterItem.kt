package com.valmiraguiar.rickandmorty.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.SubcomposeAsyncImage
import coil3.compose.SubcomposeAsyncImageContent
import com.valmiraguiar.rickandmorty.R
import com.valmiraguiar.rickandmorty.domain.entity.Character
import com.valmiraguiar.rickandmorty.theme.AppTheme
import com.valmiraguiar.rickandmorty.theme.Black100
import com.valmiraguiar.rickandmorty.theme.Dimensions
import com.valmiraguiar.rickandmorty.theme.RickAndMortyTheme
import com.valmiraguiar.rickandmorty.theme.White100
import com.valmiraguiar.rickandmorty.theme.Yellow100

private const val UNKNOWN = "unknown"
private const val MAX_LINES = 2

@Composable
fun CharacterItem(
    character: Character,
    onItemClick: () -> Unit
) {
    val personalInfo = listOf(
        character.gender,
        character.specie,
        character.type,
        character.origin
    ).filter { it.isNotBlank() && it.lowercase() != UNKNOWN }


    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(Dimensions.MainContainer)
            .clickable {
                onItemClick()
            },
        shape = RickAndMortyTheme.shape.roundedCorner,
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        colors = CardDefaults.cardColors(
            containerColor = White100
        )
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier.height(Dimensions.ImageContainer)
            ) {
                SubcomposeAsyncImage(
                    model = character.image,
                    loading = {
                        CircularProgressIndicator()
                    },
                    contentDescription = stringResource(R.string.character_image),
                    success = { state ->
                        SubcomposeAsyncImageContent(
                            contentScale = ContentScale.Crop
                        )
                    },
                    modifier = Modifier.fillMaxSize()
                )
            }

            Box(modifier = Modifier.fillMaxHeight()) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Box(
                        modifier = Modifier.padding(
                            start = Dimensions.SpacingNano,
                            end = Dimensions.SpacingNano,
                            top = Dimensions.SpacingNano,
                            bottom = 0.dp
                        )
                    ) {
                        Column {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = character.name,
                                    style = RickAndMortyTheme.typography.titleNormal,
                                    maxLines = MAX_LINES
                                )
                            }

                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                            ) {
                                Icon(
                                    imageVector = Icons.Default.LocationOn,
                                    contentDescription = "",
                                    tint = RickAndMortyTheme.colorScheme.onBackground,
                                    modifier = Modifier.size(12.dp)
                                )
                                Text(
                                    character.location,
                                    style = RickAndMortyTheme.typography.body,
                                    modifier = Modifier.padding(start = Dimensions.SpacingNano),
                                    maxLines = MAX_LINES
                                )
                            }
                        }
                    }

                    Box(contentAlignment = Alignment.BottomCenter) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .horizontalScroll(rememberScrollState())
                                .padding(
                                    start = Dimensions.SpacingNano,
                                    end = Dimensions.SpacingNano,
                                    bottom = Dimensions.SpacingNano
                                ),
                            horizontalArrangement = Arrangement.spacedBy(Dimensions.SpacingNano)
                        ) {
                            personalInfo.map {
                                Box(
                                    modifier = Modifier
                                        .background(Yellow100, RoundedCornerShape(50))
                                        .padding(
                                            horizontal = Dimensions.SpacingX,
                                            vertical = Dimensions.SpacingXNano
                                        )
                                ) {
                                    Text(
                                        text = it,
                                        color = Black100,
                                        style = RickAndMortyTheme.typography.body
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun CharacterItemPreview() {
    AppTheme {
        CharacterItem(
            Character(
                id = 1,
                name = "Rick Sanchez",
                status = "",
                specie = " ",
                type = "",
                gender = "",
                origin = "",
                location = "",
                image = ""
            )
        ) {
            println("")
        }
    }
}