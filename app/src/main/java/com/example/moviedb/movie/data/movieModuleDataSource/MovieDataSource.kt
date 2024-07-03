package com.example.moviedb.movie.data.movieModuleDataSource

import com.example.moviedb.movie.data.movieEntity.MoviesListModel
import com.example.moviedb.app.data.remote.network.ApiServices
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MovieDataSource @Inject constructor(private val apiServices: ApiServices) :
    IMovieDataSource {
    override fun getMovies(): Flow<MoviesListModel> =flow{
        apiServices.getMovies().body().let {
            it?.let { it1 -> emit(it1) }
        }
    }
}