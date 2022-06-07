package com.app.apicalling.repository

import com.app.apicalling.data.remote.MoviesRemoteDataSource
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(private val moviesRemoteDataSource: MoviesRemoteDataSource) :
    MoviesRepository {

    override suspend fun getMovies() {
        moviesRemoteDataSource.getMovies()
    }

    override suspend fun getDirectors() {
        moviesRemoteDataSource.getDirectors()
    }
}