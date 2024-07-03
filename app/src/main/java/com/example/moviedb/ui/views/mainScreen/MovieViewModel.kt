package com.example.moviedb.ui.views.mainScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviedb.data.entity.MoviesListModel
import com.example.moviedb.data.repos.MovieRepoInterface
import com.example.moviedb.utils.ViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(private val movieRepoInterface: MovieRepoInterface): ViewModel() {
    private var _moviesState : MutableStateFlow<ViewState<MoviesListModel>> = MutableStateFlow(
        ViewState.Loading)
    val moviesState :StateFlow<ViewState<MoviesListModel>> = _moviesState

    fun getMovies()
    {
        viewModelScope.launch(Dispatchers.IO){
            movieRepoInterface.getMovies().collect{
                _moviesState.value = ViewState.Success(it)
            }
        }
    }

}