package com.example.moviedb.movie.ui.views

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.moviedb.R
import com.example.moviedb.comman.theme.corner_8dp
import com.example.moviedb.comman.theme.gridCellSize
import com.example.moviedb.comman.theme.height_16dp
import com.example.moviedb.comman.theme.height_4dp
import com.example.moviedb.comman.theme.itemRoundedCornerShape
import com.example.moviedb.comman.theme.lineHeight_16
import com.example.moviedb.comman.theme.padding_16dp
import com.example.moviedb.comman.theme.padding_8dp
import com.example.moviedb.comman.ui.widgets.MovieRating
import com.example.moviedb.comman.ui.navigation.Screen
import com.example.moviedb.comman.utils.Constants
import com.example.moviedb.movie.data.movieEntity.MovieModel

@Composable
fun MovieList(movieData: List<MovieModel>, paddingValues: PaddingValues,navController: NavController) {
    LazyVerticalGrid(
        modifier = Modifier.padding(paddingValues),
        columns = GridCells.Adaptive(minSize = gridCellSize)
    ) {
        itemsIndexed(movieData) { _, movie ->
            Surface(onClick = {
                Log.i("TAG", "MovieList item click : ${movie.id}")
                navController.currentBackStackEntry?.savedStateHandle?.set(
                    key = "movie",
                    value = movie
                )
                navController.navigate(Screen.MovieDetailsScreen.route +"/"+(movie.id.toString()))
            }) {
                MovieItem(movie = movie)
            }
        }
    }
}

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
                    contentDescription = stringResource(id = R.string.movie_img),
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
fun DetailsIcon(modifier: Modifier)
{

    Icon(
        painter = painterResource(id = R.drawable.ic_more),
        contentDescription = stringResource(id = R.string.more),
        modifier = modifier
    )

}