package com.example.moviedb.movieDetails.di

import com.example.moviedb.movieDetails.data.repo.MovieDetailsRepo
import com.example.moviedb.movieDetails.domin.iRepos.IMovieDetailsRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class MovieDetailsRepoModule {
    @Binds
    abstract fun provideRMovieDataSource(movieDetailsRepo:MovieDetailsRepo): IMovieDetailsRepo

}