package com.example.moviedb.movie.data.movieModuleDataSource

import com.example.moviedb.movie.data.movieEntity.MoviesListModel
import kotlinx.coroutines.flow.Flow

interface IMovieDataSource
{
    fun getMovies(): Flow<MoviesListModel>
}