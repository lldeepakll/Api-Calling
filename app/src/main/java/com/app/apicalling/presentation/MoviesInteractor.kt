package com.app.apicalling.presentation

import com.app.apicalling.data.network.SafeApiCall
import com.app.apicalling.repository.MoviesRepository
import javax.inject.Inject

class MoviesInteractor @Inject constructor(private val moviesRepository: MoviesRepository) :
    SafeApiCall {

    suspend fun getMovies() = safeApiCall { moviesRepository.getMovies() }

    suspend fun getDirectors() = safeApiCall { moviesRepository.getDirectors() }

}