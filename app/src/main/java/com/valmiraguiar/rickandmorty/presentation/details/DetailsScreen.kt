package com.valmiraguiar.rickandmorty.presentation.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.stringResource
import androidx.core.view.drawToBitmap
import coil3.compose.AsyncImage
import com.valmiraguiar.rickandmorty.R
import com.valmiraguiar.rickandmorty.presentation.components.Loading
import com.valmiraguiar.rickandmorty.presentation.details.components.InformationData
import com.valmiraguiar.rickandmorty.theme.Blue200
import com.valmiraguiar.rickandmorty.theme.Dimensions
import com.valmiraguiar.rickandmorty.theme.Gray100
import com.valmiraguiar.rickandmorty.theme.Gray200
import com.valmiraguiar.rickandmorty.theme.RickAndMortyTheme
import com.valmiraguiar.rickandmorty.utils.bitmapToPdf
import com.valmiraguiar.rickandmorty.utils.safeDrawToBitmap
import com.valmiraguiar.rickandmorty.utils.sharePdf
import org.koin.androidx.compose.koinViewModel

private const val NAME_MAX_LINES = 2
private const val MAX_LINES = 1

@Composable
fun DetailsScreen(
    modifier: Modifier = Modifier,
    vm: DetailsViewModel = koinViewModel<DetailsViewModel>(),
    characterId: Int
) {
    val context = LocalContext.current
    val view = LocalView.current

    val detailsState by vm.state.collectAsState()

    LaunchedEffect(Unit) {
        vm.getCharacter(characterId)
    }

    Column(
        modifier = modifier
            .padding(Dimensions.SpacingX)
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(Dimensions.SpacingXSNano)
    ) {
        Loading(isVisible = detailsState.isLoading)

        detailsState.character?.let { character ->
            AsyncImage(
                model = character.image,
                contentDescription = "Character image",
                modifier = Modifier
                    .height(Dimensions.DetailsCharacterImageHeight)
                    .fillMaxWidth()
                    .clip(RickAndMortyTheme.shape.container),
                contentScale = ContentScale.FillBounds
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = Dimensions.SpacingXNano, top = Dimensions.SpacingNano),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = character.name,
                    style = RickAndMortyTheme.typography.titleLarge,
                    maxLines = NAME_MAX_LINES
                )

                Box(
                    modifier = Modifier
                        .background(Blue200, RoundedCornerShape(50))
                        .padding(
                            horizontal = Dimensions.Spacing,
                            vertical = Dimensions.SpacingXNano
                        )
                ) {
                    Text(
                        text = character.status,
                        color = Gray200,
                        style = RickAndMortyTheme.typography.labelNormal
                    )
                }
            }


            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = "Location icon",
                    tint = Blue200,
                    modifier = Modifier.size(Dimensions.SpacingXBig)
                )
                Text(
                    text = character.location,
                    style = RickAndMortyTheme.typography.labelNormal,
                    modifier = Modifier.padding(start = Dimensions.SpacingNano),
                    color = Gray100,
                    maxLines = MAX_LINES
                )
            }

            InformationData(
                modifier = Modifier.padding(top = Dimensions.SpacingXBig),
                label = stringResource(R.string.label_type),
                value = character.type
            )

            InformationData(
                label = stringResource(R.string.label_gender),
                value = character.gender
            )

            InformationData(
                label = stringResource(R.string.label_origin),
                value = character.origin
            )

            Button(modifier = Modifier, onClick = {
                val bitmap = view.safeDrawToBitmap()
                val pdfFile = bitmapToPdf(context, bitmap)
                sharePdf(context, pdfFile)
            }) {
                Text("SHARE")
            }
        }
    }
}