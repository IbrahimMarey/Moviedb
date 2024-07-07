package com.example.moviedb.movieDetails.data.dataSource

import com.example.moviedb.movieDetails.data.entity.MovieDetailsModel
import com.example.moviedb.movieDetails.data.network.MovieDetailsServices
import javax.inject.Inject

class MovieDetailsRemoteDataSource @Inject constructor(val movieDetailsServices: MovieDetailsServices):IMovieDetailsDataSource {
    override suspend fun getMovieDetails(id:String): MovieDetailsModel {
        return movieDetailsServices.getMovieDetails(id)
    }
}