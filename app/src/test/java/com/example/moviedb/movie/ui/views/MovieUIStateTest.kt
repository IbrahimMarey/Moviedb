package com.example.moviedb.movie.ui.views

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.moviedb.movie.ui.models.MovieUIModel
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MovieUIStateTest{
    @Test
    fun initialState_NoMovies() {
        val state = MovieUIState(loading = false , listOf())
        assertTrue(state.movieList.isEmpty())
    }

    @Test
    fun movieUIState_LoadingTrue() {
        val state = MovieUIState(loading = false , listOf())
        val updatedState = state.copy(loading = true)
        assertTrue(updatedState.loading)
    }

    @Test
    fun movieUIState_GetMovies() {
        val state = MovieUIState(loading = false , listOf())
        val movieList = listOf(MovieUIModel(id = 1, title = "Test Movie", releaseDate = "", posterPath = "", voteAverage = 3.0))
        val updatedState = state.copy(movieList = movieList)
        assertEquals(updatedState.movieList, movieList)
    }

}