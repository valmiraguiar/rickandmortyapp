package com.valmiraguiar.rickandmorty

import android.app.Application
import com.valmiraguiar.rickandmorty.di.ApplicationDI
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class RickAndMortyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@RickAndMortyApplication)
            androidLogger()
            ApplicationDI().load()
        }
    }
}