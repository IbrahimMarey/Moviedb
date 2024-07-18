package com.example.moviedb.movie.domin.usesCases

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.moviedb.movie.data.fakes.FakeMovieDataSource
import com.example.moviedb.movie.data.movieEntity.MovieModel
import com.example.moviedb.movie.data.movieEntity.MoviesListModel
import com.example.moviedb.movie.data.movieRepo.MovieRepo
import com.example.moviedb.movie.domin.fakes.FakeRepo
import com.example.moviedb.movie.domin.iRepos.IMovieRepo
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MoviesUseCaseTest {

    @Test
    fun getMovieUseCase_getMovies()= runBlocking{
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
        val fakeRepo = FakeRepo(movieList)

        val movieUseCase = MoviesUseCase(fakeRepo)

        // That
        movieUseCase().collect{
            // Then
            assertEquals(it[0].title , "Title 1")
        }
    }



    @Test
    fun getMovieUseCase_NullMovies()= runBlocking{
        // Given


        val movieList:MoviesListModel? = null
        val fakeRepo = FakeRepo(movieList)

        val movieUseCase = MoviesUseCase(fakeRepo)

        // That
        movieUseCase().collect{
            // Then
            assertEquals(it , null)
        }
    }


    @Test
    fun getMovieUseCase_NoMovies()= runBlocking{
        // Given
        val movieList = MoviesListModel(listOf())
        val fakeRepo = FakeRepo(movieList)

        val movieUseCase = MoviesUseCase(fakeRepo)

        // That
        movieUseCase().collect{
            // Then
            assertEquals(it.size ,0 )
        }
    }
}