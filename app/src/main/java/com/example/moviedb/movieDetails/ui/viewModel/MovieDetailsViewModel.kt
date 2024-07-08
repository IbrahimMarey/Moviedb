package com.example.moviedb.movieDetails.ui.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviedb.comman.utils.ViewState
import com.example.moviedb.movieDetails.data.entity.MovieDetailsModel
import com.example.moviedb.movieDetails.domin.useCases.MovieDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(val movieDetailsUseCase: MovieDetailsUseCase) :ViewModel() {
    private var _moviesDetailsState : MutableStateFlow<ViewState<MovieDetailsModel>> = MutableStateFlow(
        ViewState.Loading)
    val movieDetailsState : StateFlow<ViewState<MovieDetailsModel>> = _moviesDetailsState


    fun getMovieDetails(id:String)
    {
//        viewModelScope.launch(Dispatchers.IO){
            movieDetailsUseCase(id)
                .onStart {
                    _moviesDetailsState.value = ViewState.Loading

                }
                .onEach {
                _moviesDetailsState.value = ViewState.Success(it)
                    Log.i("TAG", "getMovieDetails=====================: $it")
            }.launchIn(viewModelScope)

//                .collect{
//                _moviesStateD.value = ViewState.Success(it)
//            }
//        }
    }
}