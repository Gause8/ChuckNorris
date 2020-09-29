package com.example.chucknorris.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.chucknorris.di.module.RepositoryNorrisModule
import com.example.chucknorris.model.RepositoryNorris

class ChuckViewModelProvider(val repositoryNorris: RepositoryNorris)
    : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ChuckViewModel(repositoryNorris) as T

    }

}