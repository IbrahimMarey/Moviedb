package com.example.moviedb.movie.ui.viewModels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.moviedb.movie.data.fakes.FakeMovieDataSource
import com.example.moviedb.movie.data.movieEntity.MovieModel
import com.example.moviedb.movie.data.movieEntity.MoviesListModel
import com.example.moviedb.movie.data.movieRepo.MovieRepo
import com.example.moviedb.movie.domin.entities.toDomainModel
import com.example.moviedb.movie.domin.iRepos.IMovieRepo
import com.example.moviedb.movie.domin.usesCases.MoviesUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.whenever

@RunWith(AndroidJUnit4::class)
@ExperimentalCoroutinesApi
class MovieViewModelTest{

    @Mock
    lateinit var repoMock: IMovieRepo

    @Before
    fun setUp(){
        MockitoAnnotations.openMocks(this)
    }
    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Test
    fun getMovies()= runBlocking{
        // Given

        val movie1 = MovieModel(
            adult = false,
            backdropPath = "/backdrop_path_1",
            genreIDS = listOf(1, 2, 3),
            id = 1,
            originalLanguage = "en",
            originalTitle = "Original Title 1",
            overview = "Overview 1",
            popularity = 8.5,
            posterPath = "/poster_path_1",
            releaseDate = "2023-05-01",
            title = "Title 1",
            video = false,
            voteAverage = 7.8,
            voteCount = 1234
        )

        val movie2 = MovieModel(
            adult = true,
            backdropPath = "/backdrop_path_2",
            genreIDS = listOf(4, 5, 6),
            id = 2,
            originalLanguage = "fr",
            originalTitle = "Original Title 2",
            overview = "Overview 2",
            popularity = 6.2,
            posterPath = "/poster_path_2",
            releaseDate = "2022-09-15",
            title = "Title 2",
            video = true,
            voteAverage = 6.4,
            voteCount = 789
        )

        val movieList = MoviesListModel(listOf(movie1, movie2))
        whenever(repoMock.getMovies()).thenReturn(movieList)

        val useCase = MoviesUseCase(repoMock)
        val vm = MovieViewModel(useCase)

        // That


        // Then
        assertEquals(vm.moviesUIState.value.movieList[0].id , movieList.results[0].id)
    }
}