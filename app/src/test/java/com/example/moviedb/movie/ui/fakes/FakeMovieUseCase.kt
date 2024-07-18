package com.example.moviedb.movie.ui.fakes

import com.example.moviedb.movie.data.movieEntity.MoviesListModel
import com.example.moviedb.movie.domin.entities.MovieDomainModel
import com.example.moviedb.movie.domin.entities.toDomainModel
import kotlinx.coroutines.flow.flow

class FakeMovieUseCase(val movieList : MoviesListModel?) {

    operator fun invoke() = flow<List<MovieDomainModel>> {
        movieList?.results?.let { emit( it.map { it.toDomainModel() }) }
    }
}