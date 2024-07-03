package com.example.moviedb.movie.data.movieRepoModule

import com.example.moviedb.movie.data.movieEntity.MoviesListModel
import com.example.moviedb.movie.data.movieModuleDataSource.IMovieDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieRepo @Inject constructor(private val IMovieDataSource: IMovieDataSource) :
    MovieRepoInterface {
    override fun getMovies(): Flow<MoviesListModel> {
        return IMovieDataSource.getMovies()
    }
}