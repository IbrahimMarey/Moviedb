package com.example.moviedb.movieDetails.di

import com.example.moviedb.movieDetails.domin.iRepos.IMovieDetailsRepo
import com.example.moviedb.movieDetails.domin.useCases.MovieDetailsUseCase
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