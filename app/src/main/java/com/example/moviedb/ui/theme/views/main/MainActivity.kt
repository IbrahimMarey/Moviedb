@file:Suppress("NAME_SHADOWING")

package com.example.moviedb.ui.theme.views.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.moviedb.R
import com.example.moviedb.data.entity.MovieModel
import com.example.moviedb.data.entity.MoviesListModel
import com.example.moviedb.ui.theme.MovieDBTheme
import com.example.moviedb.ui.theme.ViewState
import com.example.moviedb.utils.Constants
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val movieViewModel: MovieViewModel by viewModels()

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        movieViewModel.getMovies()
        enableEdgeToEdge()
        setContent {
            val moviesState by movieViewModel.moviesState.collectAsState()
            MovieDBTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text(getString(R.string.app_name)) },
                        )
                    },
                    modifier = Modifier.fillMaxSize()) { innerPadding ->
                    when(moviesState){
                        is ViewState.Error -> {}
                        ViewState.Loading -> {}
                        is ViewState.Success -> {
                            Greeting(movieData = (moviesState as ViewState.Success<MoviesListModel>).data.results, paddingValues = innerPadding)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(movieData: List<MovieModel>,paddingValues: PaddingValues) {
    MovieList(movieData,paddingValues)
}

@Composable
fun MovieList(movieData: List<MovieModel>,paddingValues: PaddingValues) {
    LazyVerticalGrid(
        modifier = Modifier.padding(paddingValues),
        columns = GridCells.Adaptive(minSize = 192.dp)
    ) {
        itemsIndexed(movieData) { _, movie ->
            MovieItem(movie = movie)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieItem(movie: MovieModel) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Card(onClick = {  }) {
            Column(
                modifier = Modifier.fillMaxWidth(),
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { /* Handle click event */ }
                ) {
                    AsyncImage(
                        model = Constants.IMAGE_URL + movie.posterPath,
                        contentDescription = "movie image",
                        modifier = Modifier
                            .padding(8.dp)
                            .clip(RoundedCornerShape(8.dp))
                    )

                    Box(
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .padding(top = 24.dp, end = 16.dp)
                    ) {
                        MovieRating(movie.voteAverage.toFloat())
                    }
                }
                Spacer(modifier = Modifier.width(16.dp))
                    Text(
                        text = movie.title,
                        modifier = Modifier.padding(8.dp)
                    )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = movie.releaseDate,
                    modifier = Modifier.padding(8.dp),
                    color = Color.Gray
                )
            }
        }
    }
}
@Preview
@Composable
fun MovieRating(progress: Float=7.7f) {
    val progress: Float by remember { mutableFloatStateOf(progress) }

    Card(
        modifier = Modifier.clip(
            RoundedCornerShape(
                topStartPercent = 50,
                topEndPercent = 50,
                bottomEndPercent = 50,
                bottomStartPercent = 50
            )
        )
    ) {
        Box(contentAlignment = Alignment.Center) {
            CircularProgressIndicator(
                progress = progress/10,
                trackColor = Color.Gray,
            )
            Text(

                text = "${(progress * 10).toInt()}%",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 10.sp
                ),
                modifier = Modifier.align(Alignment.Center),
            )
        }
    }
}