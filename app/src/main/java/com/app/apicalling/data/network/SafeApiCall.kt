package com.app.apicalling.data.network

import retrofit2.HttpException

interface SafeApiCall {
    suspend fun <T> safeApiCall(
        apiCall: suspend () -> T
    ): Outcome<T> {
        return try {
            Outcome.Success(apiCall.invoke())
        } catch (throwable: Throwable) {
            when (throwable) {
                is HttpException -> {
                    Outcome.Failure(false, throwable.code(), throwable.response()?.errorBody())
                }
                else -> {
                    Outcome.Failure(true, null, null)
                }
            }
        }
    }
}