package com.example.chucknorris.di.module

import com.example.chucknorris.model.Network
import com.example.chucknorris.model.RepositoryNorris
import dagger.Module
import dagger.Provides

@Module
class RepositoryNorrisModule {
    @Provides
    fun provideRepository(network: Network): RepositoryNorris{
        return RepositoryNorris(network)
    }
}