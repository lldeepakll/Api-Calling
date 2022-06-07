package com.app.apicalling.data.network

import retrofit2.http.GET

interface RestApi {

    @GET("movies")
    suspend fun getMovies()

    @GET("directors")
    suspend fun getDirectors()
}