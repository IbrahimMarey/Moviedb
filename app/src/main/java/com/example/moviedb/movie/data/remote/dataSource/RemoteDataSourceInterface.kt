package com.example.moviedb.movie.data.remote.dataSource

import com.example.moviedb.movie.data.entity.MoviesListModel
import kotlinx.coroutines.flow.Flow

interface RemoteDataSourceInterface
{
    fun getMovies(): Flow<MoviesListModel>
}