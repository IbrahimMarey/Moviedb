package com.example.moviedb.movie.domin.fakes

import com.example.moviedb.movie.data.movieEntity.MoviesListModel
import com.example.moviedb.movie.domin.iRepos.IMovieRepo

class FakeRepo(val movieList: MoviesListModel?):IMovieRepo {
    override suspend fun getMovies(): MoviesListModel? {
        return movieList
    }
}