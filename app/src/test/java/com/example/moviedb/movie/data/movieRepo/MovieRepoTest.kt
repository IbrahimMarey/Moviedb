package com.example.moviedb.movie.data.movieRepo

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.moviedb.movie.data.fakes.FakeMovieDataSource
import com.example.moviedb.movie.data.movieDataSource.IMovieDataSource
import com.example.moviedb.movie.data.movieEntity.MovieModel
import com.example.moviedb.movie.data.movieEntity.MoviesListModel
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.whenever

@RunWith(AndroidJUnit4::class)
class MovieRepoTest{
    @Mock
    lateinit var movieDataSourceMock:IMovieDataSource

    @Before
    fun setUp(){
        MockitoAnnotations.openMocks(this)
    }
    @Test
    fun testGetMovies_getAllMovies()= runBlocking{
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

        val repo = MovieRepo(movieDataSourceMock)
        whenever(movieDataSourceMock.getMovies()).thenReturn(movieList)
        // That
        val result = repo.getMovies()

        // Then
        assertEquals(result , movieList)
    }


    @Test
    fun testGetMovies_nullMovies()= runBlocking{
        // Given
        val movieList = null
        val repo = MovieRepo(movieDataSourceMock)
        whenever(movieDataSourceMock.getMovies()).thenReturn(movieList)

        // That
        val result = repo.getMovies()

        // Then
        assertEquals(result ,null )
    }

    @Test
    fun testGetMovies_NoMovies()= runBlocking{
        // Given
        val movieList = MoviesListModel(listOf())
        val repo = MovieRepo(movieDataSourceMock)
        whenever(movieDataSourceMock.getMovies()).thenReturn(movieList)

        // That
        val result = repo.getMovies()

        // Then
        assertEquals(result?.results?.size ,0 )
    }
}