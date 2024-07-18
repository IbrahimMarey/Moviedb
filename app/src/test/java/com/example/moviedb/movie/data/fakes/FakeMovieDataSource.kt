package com.example.moviedb.movie.data.fakes

import com.example.moviedb.movie.data.movieDataSource.IMovieDataSource
import com.example.moviedb.movie.data.movieEntity.MovieModel
import com.example.moviedb.movie.data.movieEntity.MoviesListModel

class FakeMovieDataSource(val movieList : MoviesListModel? ):IMovieDataSource {


    override suspend fun getMovies(): MoviesListModel? {
        return movieList
    }
}