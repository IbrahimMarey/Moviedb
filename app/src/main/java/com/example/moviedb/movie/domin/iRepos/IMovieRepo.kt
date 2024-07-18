package com.example.moviedb.movie.domin.iRepos

import com.example.moviedb.movie.data.movieEntity.MoviesListModel
import kotlinx.coroutines.flow.Flow

interface IMovieRepo {

    suspend fun getMovies(): MoviesListModel?
}