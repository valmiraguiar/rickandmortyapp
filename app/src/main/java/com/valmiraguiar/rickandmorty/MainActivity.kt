package com.valmiraguiar.rickandmorty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.valmiraguiar.rickandmorty.navigation.MainNavigation
import com.valmiraguiar.rickandmorty.presentation.components.TopBar
import com.valmiraguiar.rickandmorty.theme.AppTheme
import com.valmiraguiar.rickandmorty.theme.RickAndMortyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(RickAndMortyTheme.colorScheme.background),
                    topBar = {
                        TopBar(
                            modifier = Modifier.statusBarsPadding()
                        )
                    }
                ) { innerPadding ->
                    MainNavigation(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}