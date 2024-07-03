package com.example.moviedb.di

import com.example.moviedb.data.remote.dataSource.RemoteDataSource
import com.example.moviedb.data.remote.dataSource.RemoteDataSourceInterface
import com.example.moviedb.data.repos.MovieRepo
import com.example.moviedb.data.repos.MovieRepoInterface
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepoModule
{
    @Binds
    abstract fun provideRemoteDataSource(remoteDataSource: RemoteDataSource): RemoteDataSourceInterface

    @Binds
    abstract fun  provideMovieRepo(movieRepo: MovieRepo): MovieRepoInterface
}