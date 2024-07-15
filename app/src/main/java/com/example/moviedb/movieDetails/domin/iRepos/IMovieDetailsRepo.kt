package com.example.moviedb.movieDetails.domin.iRepos

import com.example.moviedb.movieDetails.data.entity.MovieDetailsModel

interface IMovieDetailsRepo
{
    suspend fun getMovieDetails(id:String):MovieDetailsModel
}