package com.example.moviedb.movie.di

import com.example.moviedb.movie.data.network.MovieServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MovieServicesModule {
    @Provides
    fun provideApiService(retrofit: Retrofit): MovieServices {
        return retrofit.create(MovieServices::class.java)
    }
}