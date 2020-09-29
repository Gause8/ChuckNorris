package com.example.chucknorris.model

import retrofit2.Retrofit

class Network(val api: ChuckNorrisAPI) { //3

    suspend fun getRandomJoke(): JokesResponse{
       return api.getMeRandomJoke()
    }
    suspend fun getRandomJokeWithName(firstName: String, lastName: String): JokesResponse{
        return api.getMeRandomJokeWithName(firstName,lastName)
    }
    suspend fun getRandomEndlessJoke(): JokeListResponse{
        return api.getMeRandomEndlessJokes()
    }

}