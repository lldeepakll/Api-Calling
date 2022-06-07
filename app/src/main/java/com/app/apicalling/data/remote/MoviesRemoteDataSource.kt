package com.app.apicalling.data.remote

interface MoviesRemoteDataSource {
    suspend fun getMovies()
    suspend fun getDirectors()
}