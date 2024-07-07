package com.example.moviedb.movie.di

import com.example.moviedb.movie.data.movieRepo.MovieRepo
import com.example.moviedb.movie.domin.IMovieRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepoModule
{
    @Binds
    abstract fun  provideMovieRepo(movieRepo: MovieRepo): IMovieRepo
}