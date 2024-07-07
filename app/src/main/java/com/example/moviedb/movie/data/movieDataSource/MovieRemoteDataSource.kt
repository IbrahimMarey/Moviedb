package com.example.moviedb.movie.data.movieDataSource

import com.example.moviedb.movie.data.movieEntity.MoviesListModel
import com.example.moviedb.movie.data.network.MovieServices
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MovieRemoteDataSource @Inject constructor(private val movieServices: MovieServices) :
    IMovieDataSource {
    override fun getMovies(): Flow<MoviesListModel> =flow{
        movieServices.getMovies().body().let {
            it?.let { it1 -> emit(it1) }
        }
    }
}