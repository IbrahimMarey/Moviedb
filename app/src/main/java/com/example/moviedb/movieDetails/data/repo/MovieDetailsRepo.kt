package com.example.moviedb.movieDetails.data.repo

import com.example.moviedb.movieDetails.data.dataSource.IMovieDetailsDataSource
import com.example.moviedb.movieDetails.data.entity.MovieDetailsModel
import com.example.moviedb.movieDetails.domin.IMovieDetailsRepo
import javax.inject.Inject

class MovieDetailsRepo @Inject constructor(val iMovieDetailsDataSource: IMovieDetailsDataSource):IMovieDetailsRepo {
    override suspend fun getMovieDetails(id: String): MovieDetailsModel {
        return iMovieDetailsDataSource.getMovieDetails(id)
    }
}