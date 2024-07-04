package com.example.moviedb.movie.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviedb.movie.data.movieEntity.MoviesListModel
import com.example.moviedb.movie.data.movieRepoModule.MovieRepoInterface
import com.example.moviedb.comman.utils.ViewState
import com.example.moviedb.movie.domin.GetMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(/*private val movieRepoInterface: MovieRepoInterface,*/ private val getMoviesUseCase: GetMoviesUseCase): ViewModel() {
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

    private var _moviesStateD : MutableStateFlow<ViewState<MoviesListModel>> = MutableStateFlow(
        ViewState.Loading)
    val moviesStateD :StateFlow<ViewState<MoviesListModel>> = _moviesStateD

    fun getMoviesUseCase()
    {
        viewModelScope.launch(Dispatchers.IO){
            getMoviesUseCase.invoke().collect{
                _moviesStateD.value = ViewState.Success(it)
            }
        }
    }
}