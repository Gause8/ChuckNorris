package com.example.chucknorris.viewmodel

import androidx.lifecycle.*
import com.example.chucknorris.model.JokesResponse
import com.example.chucknorris.model.RepositoryNorris
import kotlinx.coroutines.launch

class ChuckViewModel(var repositoryNorris: RepositoryNorris): ViewModel() {

    val liveDataSingleJoke: LiveData<JokesResponse> =
        liveData{
            emit(repositoryNorris.getRandomJoke())
    }

    val mutableLiveDataSingleJoke = MutableLiveData<JokesResponse>()
    fun getSingleJokeLiveData():LiveData<JokesResponse> = mutableLiveDataSingleJoke
    fun getSingleJoke(){
        viewModelScope.launch {
            mutableLiveDataSingleJoke.value
            repositoryNorris.getRandomJoke()
        }
    }

    val mutableLivedataNamedJoke = MutableLiveData<JokesResponse>()
    fun getNamedJokeLiveData():LiveData<JokesResponse> = mutableLivedataNamedJoke
    fun getNamedJoke(firstName: String, lastName: String) {
        viewModelScope.launch {
            mutableLiveDataSingleJoke.value
            repositoryNorris.getNamedJoke(firstName,lastName)
        }
    }

    val mutableLiveDataEndlessJoke = MutableLiveData<JokesResponse>()
    fun getEndlessJokeLiveData(): LiveData<JokesResponse> = mutableLiveDataEndlessJoke
    fun getEndlessJoke() {
        viewModelScope.launch {
            mutableLiveDataEndlessJoke.value
            repositoryNorris.getListOfJokes()
        }

    }
}