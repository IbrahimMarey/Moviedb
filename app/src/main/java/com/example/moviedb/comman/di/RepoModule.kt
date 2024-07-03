package com.example.moviedb.comman.di

import com.example.moviedb.movie.data.movieModuleDataSource.MovieDataSource
import com.example.moviedb.movie.data.movieModuleDataSource.IMovieDataSource
import com.example.moviedb.movie.data.movieRepoModule.MovieRepo
import com.example.moviedb.movie.data.movieRepoModule.MovieRepoInterface
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepoModule
{
    @Binds
    abstract fun provideRemoteDataSource(remoteDataSource: MovieDataSource): IMovieDataSource

    @Binds
    abstract fun  provideMovieRepo(movieRepo: MovieRepo): MovieRepoInterface
}