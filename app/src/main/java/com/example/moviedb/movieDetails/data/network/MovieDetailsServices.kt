package com.example.moviedb.movieDetails.data.network

import com.example.moviedb.comman.utils.Constants
import com.example.moviedb.movieDetails.data.entity.MovieDetailsModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieDetailsServices
{
    @GET("{id}")
    suspend fun getMovieDetails(
        @Path("id") id : String,
        @Query("api_key") apiKey:String = Constants.API_KEY ): MovieDetailsModel
}