package com.example.moviedb.data.repos

import com.example.moviedb.data.entity.MoviesListModel
import com.example.moviedb.data.remote.dataSource.RemoteDataSourceInterface
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieRepo @Inject constructor(private val remoteDataSourceInterface: RemoteDataSourceInterface) :
    MovieRepoInterface {
    override fun getMovies(): Flow<MoviesListModel> {
        return remoteDataSourceInterface.getMovies()
    }
}