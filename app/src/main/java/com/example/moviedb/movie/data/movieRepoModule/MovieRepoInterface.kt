package com.example.moviedb.movie.data.movieRepoModule

import com.example.moviedb.movie.data.movieEntity.MoviesListModel
import kotlinx.coroutines.flow.Flow

interface MovieRepoInterface {

    fun getMovies(): Flow<MoviesListModel>
}