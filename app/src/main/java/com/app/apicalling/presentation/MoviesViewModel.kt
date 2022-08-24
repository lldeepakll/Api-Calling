package com.app.apicalling.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@HiltViewModel
class MoviesViewModel @Inject constructor(private val moviesInteractor: MoviesInteractor) :
    ViewModel() {

    init {

        CoroutineScope(Dispatchers.Main).launch {
            moviesInteractor.getMovies()
            moviesInteractor.getDirectors()
        }

    }

    fun duplicateCharInStr(s: String) {

        if (s.isNotBlank()) {
            val length = s.length
            var counter = 0

            for (i in 0 until length) {

                val temp = s[i]

                for (j in 0 until length) {

                    if (temp == s[j]) {
                        counter++;
                    }

                }
                Log.e("The Char $temp", "Count : $counter")
                counter = 0;
            }
        }
    }

    fun findPeakElement(arr: IntArray, len : Int) : Int{

        if (len == 1) return 0
        if (arr[0] >= arr[1]) return 0
        if (arr[len - 1] >= arr[len - 2]) return len - 1

        for (i in 1 until len - 1) {
            if (arr[i] >= arr[i - 1] && arr[i] >= arr[i + 1]) return i
        }
        return 0
    }

}