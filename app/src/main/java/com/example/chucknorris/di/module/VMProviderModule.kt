package com.example.chucknorris.di.module

import com.example.chucknorris.model.RepositoryNorris
import com.example.chucknorris.viewmodel.ChuckViewModelProvider
import dagger.Module
import dagger.Provides

@Module
class VMProviderModule {
    @Provides
    fun provideVMProvider(repositoryNorris: RepositoryNorris)
    :ChuckViewModelProvider = ChuckViewModelProvider(repositoryNorris)
}