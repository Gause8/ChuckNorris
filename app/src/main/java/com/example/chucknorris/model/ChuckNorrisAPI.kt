package com.example.chucknorris.model

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ChuckNorrisAPI {//2
    //http://api.icndb.com/jokes/random


    @GET("jokes/random")
    suspend fun getMeRandomJoke(): JokesResponse

    //http://api.icndb.com/jokes/random?firstName=John&amp;lastName=Doe
    @GET("/jokes/random")
    suspend fun getMeRandomJokeWithName(
        @Query("firstName") firstName: String, // able to pass differnt name
        @Query("lastName") lastName: String // checks ?
    ): JokesResponse

//http://api.icndb.com/jokes/random/20
    @GET("jokes/random/{size}")
    suspend fun getMeRandomEndlessJokes(
    @Path("size") limit: Int = 20 // inserts after /
): JokeListResponse
}