package com.example.moviedb.comman.network

import com.example.moviedb.movie.data.movieEntity.MoviesListModel
import com.example.moviedb.comman.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {
    @GET("now_playing")
    suspend fun getMovies(
        @Query("language") language:String = "en-US",
        @Query("page")page:String = "1" ,
        @Query("api_key") apiKey:String = Constants.API_KEY ):Response<MoviesListModel>
}