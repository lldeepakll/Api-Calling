package com.app.apicalling.repository

interface MoviesRepository {

    suspend fun getMovies()
    suspend fun getDirectors()
}