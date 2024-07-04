package com.example.moviedb.comman.di

import com.example.moviedb.movie.data.movieRepoModule.MovieRepoInterface
import com.example.moviedb.movie.domin.GetMoviesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class GetMoviesUseCaseModule
{
    @Provides
    fun provideUseCase(movieRepoInterface: MovieRepoInterface) : GetMoviesUseCase{
        return GetMoviesUseCase(movieRepoInterface)
    }

}