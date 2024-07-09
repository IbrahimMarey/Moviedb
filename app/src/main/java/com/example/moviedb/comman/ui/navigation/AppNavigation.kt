package com.example.moviedb.comman.ui.navigation

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.moviedb.R
import com.example.moviedb.comman.utils.ViewState
import com.example.moviedb.movie.data.movieEntity.MovieModel
import com.example.moviedb.movie.data.movieEntity.MoviesListModel
import com.example.moviedb.movie.ui.viewModels.MovieViewModel
import com.example.moviedb.movie.ui.views.MovieList
import com.example.moviedb.movieDetails.data.entity.MovieDetailsModel
import com.example.moviedb.movieDetails.ui.viewModel.MovieDetailsViewModel


@Composable
fun MovieDBNavigation(
    movieViewModel: MovieViewModel,
    movieDetailsViewModel: MovieDetailsViewModel,
)
{
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.HomeScreen.route ) {
        composable(Screen.HomeScreen.route){
            MoviesHomeScreen(
                movieViewModel= movieViewModel,
                navController = navController
            )
        }
        composable(
            Screen.MovieDetailsScreen.route + "/{movie_id}",
            arguments = listOf(navArgument("movie_id"){
                type = NavType.StringType
                defaultValue="null"
                nullable = false
            }
            )
        ){ entry->
//            LaunchedEffect(key1 = entry) {
//                val movie = navController.previousBackStackEntry?.savedStateHandle?.get<MovieModel>("movie")
//                Log.i("TAG", "clicked movie = = =  $movie")
//            }
            val movie = navController.previousBackStackEntry?.savedStateHandle?.get<MovieModel>("movie")
            Log.i("TAG", "clicked movie = = =  $movie")
            if(entry.arguments?.getString("movie_id") != null )
                Log.i("TAG", "MovieDBNavigation: ${entry.arguments?.getString("movie_id")}")
            MovieDetailsScreen(id = entry.arguments?.getString("movie_id"), detailsViewModel = movieDetailsViewModel,movie=movie)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoviesHomeScreen(movieViewModel: MovieViewModel,navController:NavController)
{
    val moviesState by movieViewModel.moviesStateD.collectAsState()
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.app_name)) },
                )
                 },
        modifier = Modifier.fillMaxSize()) {
        innerPadding ->
        when(moviesState){

            is ViewState.Error -> {
//                           Toast.makeText(this, "error", Toast.LENGTH_SHORT).show()
            }
            ViewState.Loading -> {
//                           Toast.makeText(this, "loading", Toast.LENGTH_SHORT).show()
            }
            is ViewState.Success -> {
                MovieList(movieData = (moviesState as ViewState.Success<MoviesListModel>).data.results, paddingValues = innerPadding,navController = navController,)                        }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieDetailsScreen(id:String?, detailsViewModel: MovieDetailsViewModel,movie:MovieModel?)
{
    Log.i("TAG", "Movie id = = = = = = = = =  ${id}")
    LaunchedEffect(key1 = id) {
        id?.let { detailsViewModel.getMovieDetails(it) }
    }
    val movieDetailsState by detailsViewModel.movieDetailsState.collectAsState()
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.app_name)) },
            )
        },
        modifier = Modifier.fillMaxSize()) {
            innerPadding ->
        when(movieDetailsState){
            is ViewState.Error -> {
//                            Toast.makeText(this, "error", Toast.LENGTH_SHORT).show()

            }
            ViewState.Loading -> {
//                            Toast.makeText(this, "loading", Toast.LENGTH_SHORT).show()
            }
            is ViewState.Success -> {
                com.example.moviedb.movieDetails.ui.views.MovieDetailsScreen(
                    movieDetailsModel = (movieDetailsState as ViewState.Success<MovieDetailsModel>).data,
                    paddingValues = innerPadding,
                    movie = movie
                )
            }
        }
    }
}

