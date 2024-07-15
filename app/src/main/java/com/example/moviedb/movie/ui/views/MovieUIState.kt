package com.example.moviedb.movie.ui.views

import com.example.moviedb.movie.ui.models.MovieUIModel

data class MovieUIState(val loading :Boolean,var movieList:List<MovieUIModel>)
