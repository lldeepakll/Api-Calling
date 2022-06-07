package com.app.apicalling.data.network

import okhttp3.ResponseBody

sealed class Outcome<out T> {

    data class Success<out T>(val value: T) : Outcome<T>()

    data class Failure(
        val isNetworkError: Boolean,
        val errorCode: Int?,
        val errorBody: ResponseBody?
    ) : Outcome<Nothing>()
}