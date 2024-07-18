package com.example.moviedb.movie.ui.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviedb.movie.data.movieEntity.MoviesListModel
import com.example.moviedb.comman.utils.ViewState
import com.example.moviedb.movie.domin.usesCases.MoviesUseCase
import com.example.moviedb.movie.ui.models.toUIModel
import com.example.moviedb.movie.ui.views.MovieUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(private val moviesUseCase: MoviesUseCase): ViewModel() {  /*private val movieRepoInterface: MovieRepoInterface,*/
    private var _moviesUIState : MutableStateFlow<MovieUIState> = MutableStateFlow(MovieUIState(true,listOf()
    ))
    val moviesUIState :StateFlow<MovieUIState> = _moviesUIState


    init {
        getMovies()
    }

    fun getMovies()
    {
        moviesUseCase()
            .onStart {
                _moviesUIState.update { it.copy(loading = true) }
            }
            .onCompletion {
                _moviesUIState.update { it.copy(loading = false) }
            }
            .catch { e ->
                Log.e("TAG", "fetchMovies: ${e}")
            }
            .onEach { movies ->
                _moviesUIState.update { it.copy(movieList = movies.map { it.toUIModel() }) }
            }
            .launchIn(viewModelScope)
    }
}