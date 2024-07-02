package com.example.moviedb.data.repos

import com.example.moviedb.data.entity.MoviesListModel
import kotlinx.coroutines.flow.Flow

interface MovieRepoInterface {

    fun getMovies(): Flow<MoviesListModel>
}