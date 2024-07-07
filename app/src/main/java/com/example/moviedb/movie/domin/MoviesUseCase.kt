package com.example.moviedb.movie.domin

import com.example.moviedb.movie.data.movieEntity.MoviesListModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MoviesUseCase @Inject constructor(private val iMovieRepo: IMovieRepo)
{
    operator fun invoke(): Flow<MoviesListModel> {
        return iMovieRepo.getMovies()
    }
}