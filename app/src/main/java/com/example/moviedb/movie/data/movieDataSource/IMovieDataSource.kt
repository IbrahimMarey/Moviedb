package com.example.moviedb.movie.data.movieDataSource

import com.example.moviedb.movie.data.movieEntity.MoviesListModel
import kotlinx.coroutines.flow.Flow

interface IMovieDataSource
{
    suspend fun getMovies(): MoviesListModel?
}