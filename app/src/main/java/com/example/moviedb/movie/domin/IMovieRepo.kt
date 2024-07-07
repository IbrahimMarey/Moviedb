package com.example.moviedb.movie.domin

import com.example.moviedb.movie.data.movieEntity.MoviesListModel
import kotlinx.coroutines.flow.Flow

interface IMovieRepo {

    fun getMovies(): Flow<MoviesListModel>
}