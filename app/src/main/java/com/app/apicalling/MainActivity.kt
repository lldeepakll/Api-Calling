package com.app.apicalling

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.app.apicalling.presentation.MoviesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MoviesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.duplicateCharInStr("Deepak")

        val numbers = intArrayOf(10, 20, 130, 50, 40)
        val value = viewModel.findPeakElement(numbers,5)

        Log.e("Peak Value", numbers[value].toString())

    }

}