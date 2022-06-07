package com.app.apicalling.data.remote

import com.app.apicalling.data.network.RestApi
import javax.inject.Inject

class MoviesRemoteDataSourceImpl @Inject constructor(private val restApi: RestApi) :
    MoviesRemoteDataSource {

    override suspend fun getMovies() {
        restApi.getMovies()
    }

    override suspend fun getDirectors() {
        restApi.getDirectors()
    }
}