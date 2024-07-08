package com.example.moviedb.movie.data.movieRepo

import com.example.moviedb.movie.data.movieEntity.MoviesListModel
import com.example.moviedb.movie.data.movieDataSource.IMovieDataSource
import com.example.moviedb.movie.domin.iRepos.IMovieRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieRepo @Inject constructor(private val iMovieDataSource: IMovieDataSource) :
    IMovieRepo {
    override fun getMovies(): Flow<MoviesListModel> {
        return iMovieDataSource.getMovies()
    }
}