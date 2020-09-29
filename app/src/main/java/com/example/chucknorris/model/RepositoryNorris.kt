package com.example.chucknorris.model

/**
 * class that defines getting data from cach
 * in a offline mode or getting data from
 * network call
 */
class RepositoryNorris(val network: Network) {
    suspend fun  getRandomJoke(): JokesResponse{
        //if(checkNetworkConnection())
            return network.getRandomJoke()
    }
    suspend fun getNamedJoke(firstName: String, lastName: String): JokesResponse{
        return network.getRandomJokeWithName(firstName,lastName)
    }
    suspend fun getListOfJokes(): JokeListResponse{
        return network.getRandomEndlessJoke()
    }

    /**
     * @return true if devices is online
     */
    private fun checkNetworkConnection(): Boolean{
        return true
    }

}