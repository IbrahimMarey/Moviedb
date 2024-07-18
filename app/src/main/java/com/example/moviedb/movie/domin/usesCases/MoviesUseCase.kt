package com.example.moviedb.movie.domin.usesCases

import com.example.moviedb.movie.data.movieEntity.MoviesListModel
import com.example.moviedb.movie.domin.entities.MovieDomainModel
import com.example.moviedb.movie.domin.entities.toDomainModel
import com.example.moviedb.movie.domin.iRepos.IMovieRepo
import com.example.moviedb.movie.ui.models.MovieUIModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MoviesUseCase @Inject constructor(private val iMovieRepo: IMovieRepo)
{
    operator fun invoke() =flow<List<MovieDomainModel>> {
        iMovieRepo.getMovies()?.let { emit( it.results.map { it.toDomainModel() }) }
    }
}