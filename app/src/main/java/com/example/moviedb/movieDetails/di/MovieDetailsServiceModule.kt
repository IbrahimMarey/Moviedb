package com.example.moviedb.movieDetails.di

import com.example.moviedb.movieDetails.data.network.MovieDetailsServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class MovieDetailsServiceModule
{
    @Provides
    fun provideApiService(retrofit: Retrofit): MovieDetailsServices {
        return retrofit.create(MovieDetailsServices::class.java)
    }
}