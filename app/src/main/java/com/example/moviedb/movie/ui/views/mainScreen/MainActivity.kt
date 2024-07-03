@file:Suppress("NAME_SHADOWING")

package com.example.moviedb.movie.ui.views.mainScreen

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
import coil.compose.AsyncImage
import com.example.moviedb.R
import com.example.moviedb.data.entity.MovieModel
import com.example.moviedb.data.entity.MoviesListModel
import com.example.moviedb.theme.MovieDBTheme
import com.example.moviedb.theme.corner_8dp
import com.example.moviedb.theme.fontSize_12sp
import com.example.moviedb.theme.gridCellSize
import com.example.moviedb.theme.height_16dp
import com.example.moviedb.theme.height_4dp
import com.example.moviedb.theme.itemRoundedCornerShape
import com.example.moviedb.theme.lineHeight_16
import com.example.moviedb.theme.padding_16dp
import com.example.moviedb.theme.padding_8dp
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
fun Greeting(movieData: List<MovieModel>, paddingValues: PaddingValues) {
    MovieList(movieData,paddingValues)
}

@Composable
fun MovieList(movieData: List<MovieModel>, paddingValues: PaddingValues) {
    LazyVerticalGrid(
        modifier = Modifier.padding(paddingValues),
        columns = GridCells.Adaptive(minSize = gridCellSize)
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
            .padding(padding_16dp)
            .fillMaxWidth(),
    ){
        Box{
            Column {
                AsyncImage(
                    model = Constants.IMAGE_URL + movie.posterPath,
                    contentDescription = "movie image",
                    modifier = Modifier
                        .clip(RoundedCornerShape(corner_8dp))
                        .fillMaxWidth()

                    ,
                    contentScale = ContentScale.Crop

                )
                Spacer(
                    modifier = Modifier
                        .height(height_16dp)
                        .fillMaxWidth()
                )
            }
            DetailsIcon(
                modifier = Modifier
                    .padding(end = padding_8dp, top = padding_8dp)
                    .background(color = Color.Gray, shape = RoundedCornerShape(corner_8dp))
                    .align(Alignment.TopEnd)
            )
            MovieRating(
                movie.voteAverage.toFloat(),
                Modifier
                    .padding(start = padding_16dp)
                    .align(Alignment.BottomStart)
                    .clip(
                        RoundedCornerShape(
                            topStartPercent = itemRoundedCornerShape,
                            topEndPercent = itemRoundedCornerShape,
                            bottomEndPercent = itemRoundedCornerShape,
                            bottomStartPercent = itemRoundedCornerShape
                        )
                    )
            )
        }
        Spacer(modifier = Modifier.height(height_4dp))
        Text(
            text = movie.title,
            lineHeight = lineHeight_16
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
                    fontSize = fontSize_12sp
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