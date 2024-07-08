package com.example.moviedb.movie.di

import com.example.moviedb.movie.domin.iRepos.IMovieRepo
import com.example.moviedb.movie.domin.usesCases.MoviesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class MovieUseCaseModule
{
    @Provides
    fun provideUseCase(iMovieRepo: IMovieRepo) : MoviesUseCase {
        return MoviesUseCase(iMovieRepo)
    }

}