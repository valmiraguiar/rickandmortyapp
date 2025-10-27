package com.valmiraguiar.rickandmorty.di

import com.valmiraguiar.rickandmorty.BuildConfig
import com.valmiraguiar.rickandmorty.data.infrastructure.MoshiHttp
import com.valmiraguiar.rickandmorty.data.infrastructure.MoshiHttpImpl
import com.valmiraguiar.rickandmorty.data.infrastructure.OkHttpBuilder
import com.valmiraguiar.rickandmorty.data.infrastructure.RetrofitBuilder
import com.valmiraguiar.rickandmorty.data.infrastructure.create
import com.valmiraguiar.rickandmorty.data.mapper.CharacterListMapper
import com.valmiraguiar.rickandmorty.data.mapper.CharacterListMapperImpl
import com.valmiraguiar.rickandmorty.data.mapper.CharacterMapper
import com.valmiraguiar.rickandmorty.data.mapper.CharacterMapperImpl
import com.valmiraguiar.rickandmorty.data.remote.RickAndMortyApi
import com.valmiraguiar.rickandmorty.data.repository.CharacterPagingSource
import com.valmiraguiar.rickandmorty.data.repository.CharacterRepositoryImpl
import com.valmiraguiar.rickandmorty.domain.repository.CharacterRepository
import com.valmiraguiar.rickandmorty.domain.usecases.CharacterUseCase
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
                factoryData()
                factoryViewModel()
                factoryRepository()
                factoryData()
                factoryMapper()
                factoryUseCase()
            }
        )
    }

    private fun Module.factoryData() {
        single<MoshiHttp> {
            MoshiHttpImpl(
                retrofit = get()
            )
        }
        factory {
            get<MoshiHttp>().create<RickAndMortyApi>()
        }
        single { OkHttpBuilder().build() }
        single {
            RetrofitBuilder(
                baseUrl = BuildConfig.BASE_URL_API,
                client = get()
            ).build()
        }
    }

    private fun Module.factoryViewModel() {
        viewModel {
            HomeViewModel(
                characterUseCase = get()
            )
        }
        viewModel {
            DetailsViewModel(
                characterUseCase = get()
            )
        }
    }

    private fun Module.factoryRepository() {
        factory {
            CharacterPagingSource(
                api = get(),
                mapper = get()
            )
        }

        factory<CharacterRepository> {
            CharacterRepositoryImpl(
                api = get(),
                characterPagingSource = get(),
                mapper = get()
            )
        }
    }

    private fun Module.factoryMapper() {
        factory<CharacterListMapper> { CharacterListMapperImpl() }
        factory<CharacterMapper> { CharacterMapperImpl() }
    }

    private fun Module.factoryUseCase() {
        factory {
            CharacterUseCase(
                repository = get()
            )
        }
    }
}