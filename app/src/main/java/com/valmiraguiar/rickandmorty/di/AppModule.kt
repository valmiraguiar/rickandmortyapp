package com.valmiraguiar.rickandmorty.di

import com.valmiraguiar.rickandmorty.presentation.details.DetailsViewModel
import com.valmiraguiar.rickandmorty.presentation.home.HomeViewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

class ApplicationDI {
    fun load() {
        loadKoinModules(
            module {
                factoryViewModel()
            }
        )
    }

    private fun Module.factoryViewModel() {
        viewModel { HomeViewModel() }
        viewModel { DetailsViewModel() }
    }
}
