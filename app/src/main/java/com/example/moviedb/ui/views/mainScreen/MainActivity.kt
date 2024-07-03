@file:Suppress("NAME_SHADOWING")

package com.example.moviedb.ui.views.mainScreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.moviedb.R
import com.example.moviedb.data.entity.MovieModel
import com.example.moviedb.data.entity.MoviesListModel
import com.example.moviedb.ui.theme.MovieDBTheme
import com.example.moviedb.utils.ViewState
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
    Column (
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
    ){
        Box{
            Column {
                AsyncImage(
                    model = Constants.IMAGE_URL + movie.posterPath,
                    contentDescription = "movie image",
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .fillMaxWidth()

                    ,
                    contentScale = ContentScale.Crop

                )
                Spacer(
                    modifier = Modifier
                        .height(20.dp)
                        .fillMaxWidth()
                )
            }
            DetailsIcon(
                modifier = Modifier
                    .padding(end = 8.dp, top = 8.dp)
                    .background(color = Color.Gray, shape = RoundedCornerShape(8.dp))
                    .align(Alignment.TopEnd)
            )
            MovieRating(
                movie.voteAverage.toFloat(),
                Modifier
                    .padding(start = 16.dp)
                    .align(Alignment.BottomStart)
                    .clip(
                        RoundedCornerShape(
                            topStartPercent = 50,
                            topEndPercent = 50,
                            bottomEndPercent = 50,
                            bottomStartPercent = 50
                        )
                    )
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = movie.title,
        )
        Text(
            text = movie.releaseDate,
            color = Color.Gray
        )
    }
}
@Composable
fun MovieRating(progress: Float=7.7f, modifier: Modifier) {
    val progress: Float by remember { mutableFloatStateOf(progress) }

    Card(
        modifier = modifier
    ) {
        Box(contentAlignment = Alignment.Center) {
            CircularProgressIndicator(
                progress = progress/10,
                trackColor = Color.Gray,
            )
            Text(

                text = stringResource(
                    id = R.string.movie_percentage_rate,
                    (progress * 10).toInt()),
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 10.sp
                ),
                modifier = Modifier.align(Alignment.Center),
            )
        }
    }
}
@Composable
fun DetailsIcon(modifier: Modifier)
{

    Icon(
        painter = painterResource(id = R.drawable.ic_more),
        contentDescription = "Localized description",
        modifier = modifier
    )

}