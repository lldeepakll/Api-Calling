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

}