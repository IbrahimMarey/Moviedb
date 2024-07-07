package com.example.moviedb.movie.di

import com.example.moviedb.movie.data.movieDataSource.IMovieDataSource
import com.example.moviedb.movie.data.movieDataSource.MovieRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class MovieDataSourceModule {
    @Binds
    abstract fun provideRMovieDataSource(dataSource: MovieRemoteDataSource): IMovieDataSource

}