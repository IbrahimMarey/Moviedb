package com.example.moviedb.movieDetails.di

import com.example.moviedb.movieDetails.data.dataSource.IMovieDetailsDataSource
import com.example.moviedb.movieDetails.data.dataSource.MovieDetailsRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class MovieDetailsDataSourceModule
{
    @Binds
    abstract fun provideRMovieDataSource(dataSource: MovieDetailsRemoteDataSource): IMovieDetailsDataSource

}