package com.example.moviedb.movie.ui.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviedb.movie.data.movieEntity.MoviesListModel
import com.example.moviedb.comman.utils.ViewState
import com.example.moviedb.movie.domin.usesCases.MoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(private val moviesUseCase: MoviesUseCase): ViewModel() {  /*private val movieRepoInterface: MovieRepoInterface,*/
    private var _moviesStateD : MutableStateFlow<ViewState<MoviesListModel>> = MutableStateFlow(
        ViewState.Loading)
    val moviesStateD :StateFlow<ViewState<MoviesListModel>> = _moviesStateD

    init {
        getMovies()
    }

    fun getMovies()
    {
        Log.i("TAG", "getMovies: ==============")
        viewModelScope.launch(Dispatchers.IO){
            moviesUseCase().collect{
                _moviesStateD.value = ViewState.Success(it)
            }
        }
    }

    /*private var _moviesState : MutableStateFlow<ViewState<MoviesListModel>> = MutableStateFlow(
        ViewState.Loading)
    val moviesState :StateFlow<ViewState<MoviesListModel>> = _moviesState

    fun getMovies()
    {
        viewModelScope.launch(Dispatchers.IO){
            movieRepoInterface.getMovies().collect{
                _moviesState.value = ViewState.Success(it)
            }
        }
    }*/
}