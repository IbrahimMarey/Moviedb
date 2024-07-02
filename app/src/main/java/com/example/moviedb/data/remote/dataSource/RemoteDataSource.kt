package com.example.moviedb.data.remote.dataSource

import com.example.moviedb.data.entity.MoviesListModel
import com.example.moviedb.data.remote.network.MovieServices
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val movieServices: MovieServices) :RemoteDataSourceInterface {
    override fun getMovies(): Flow<MoviesListModel> =flow{
        movieServices.getMovies().body().let {
            it?.let { it1 -> emit(it1) }
        }
    }
}