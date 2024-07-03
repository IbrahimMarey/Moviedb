package com.example.moviedb.movie.data.repos

import com.example.moviedb.movie.data.entity.MoviesListModel
import kotlinx.coroutines.flow.Flow

interface MovieRepoInterface {

    fun getMovies(): Flow<MoviesListModel>
}