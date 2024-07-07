package com.example.moviedb.movieDetails.data.dataSource

import com.example.moviedb.movieDetails.data.entity.MovieDetailsModel

interface IMovieDetailsDataSource {
    suspend fun getMovieDetails(id:String):MovieDetailsModel
}