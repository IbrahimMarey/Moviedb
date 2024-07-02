package com.example.moviedb.data.remote.dataSource

import com.example.moviedb.data.entity.MovieModel
import com.example.moviedb.data.entity.MoviesListModel
import kotlinx.coroutines.flow.Flow

interface RemoteDataSourceInterface
{
    fun getMovies(): Flow<MoviesListModel>
}