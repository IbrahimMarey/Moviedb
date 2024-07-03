package com.example.moviedb.movie.data.remote.network

import com.example.moviedb.movie.data.entity.MoviesListModel
import com.example.moviedb.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieServices {
    @GET("now_playing")
    suspend fun getMovies(
        @Query("language") language:String = "en-US",
        @Query("page")page:String = "1" ,
        @Query("api_key") apiKey:String = Constants.API_KEY ):Response<MoviesListModel>
}