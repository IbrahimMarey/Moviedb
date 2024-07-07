package com.example.moviedb.movieDetails.domin

import com.example.moviedb.movieDetails.data.entity.MovieDetailsModel
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MovieDetailsUseCase @Inject constructor(val iMovieDetailsRepo: IMovieDetailsRepo){
    operator fun invoke(id:String) = flow<MovieDetailsModel>{
        emit(iMovieDetailsRepo.getMovieDetails(id))
    }
}