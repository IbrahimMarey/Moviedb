package com.example.moviedb.movie.domin

import com.example.moviedb.movie.data.movieEntity.MoviesListModel
import com.example.moviedb.movie.data.movieRepoModule.MovieRepoInterface
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(private val iMovieRepo:MovieRepoInterface)
{
    operator fun invoke(): Flow<MoviesListModel> {
        return iMovieRepo.getMovies()
    }
}