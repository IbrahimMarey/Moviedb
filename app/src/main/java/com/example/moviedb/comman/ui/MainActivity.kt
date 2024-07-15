//@file:Suppress("NAME_SHADOWING")

package com.example.moviedb.comman.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.example.moviedb.movie.ui.viewModels.MovieViewModel
import com.example.moviedb.comman.theme.MovieDBTheme
import com.example.moviedb.comman.ui.navigation.MovieDBNavigation
import com.example.moviedb.movieDetails.ui.viewModel.MovieDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val movieViewModel: MovieViewModel by viewModels()
    private val movieDetailsViewModel: MovieDetailsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MovieDBTheme {
                MovieDBNavigation(
                    movieViewModel = movieViewModel,
                    movieDetailsViewModel = movieDetailsViewModel
                )
            }
        }
    }
}