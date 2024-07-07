package com.example.moviedb.movieDetails.di

import com.example.moviedb.movie.domin.IMovieRepo
import com.example.moviedb.movie.domin.MoviesUseCase
import com.example.moviedb.movieDetails.domin.IMovieDetailsRepo
import com.example.moviedb.movieDetails.domin.MovieDetailsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class MovieDetailsUseCaseModule {
    @Provides
    fun provideUseCase(iMovieDetailsRepo: IMovieDetailsRepo) : MovieDetailsUseCase {
        return MovieDetailsUseCase(iMovieDetailsRepo)
    }
}