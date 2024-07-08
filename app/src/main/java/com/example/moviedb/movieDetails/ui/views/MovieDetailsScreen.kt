package com.example.moviedb.movieDetails.ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import com.example.moviedb.R
import com.example.moviedb.comman.theme.blueDark
import com.example.moviedb.comman.theme.corner_16dp
import com.example.moviedb.comman.theme.corner_20dp
import com.example.moviedb.comman.theme.corner_4dp
import com.example.moviedb.comman.theme.corner_8dp
import com.example.moviedb.comman.theme.fontSize_10sp
import com.example.moviedb.comman.theme.fontSize_12sp
import com.example.moviedb.comman.theme.fontSize_16sp
import com.example.moviedb.comman.theme.fontSize_24sp
import com.example.moviedb.comman.theme.height_32dp
import com.example.moviedb.comman.theme.itemRoundedCornerShape
import com.example.moviedb.comman.theme.lineHeight_16
import com.example.moviedb.comman.theme.padding_16dp
import com.example.moviedb.comman.theme.padding_24dp
import com.example.moviedb.comman.theme.padding_4dp
import com.example.moviedb.comman.theme.padding_8dp
import com.example.moviedb.comman.theme.width_144dp
import com.example.moviedb.comman.theme.width_32dp
import com.example.moviedb.comman.ui.widgets.MovieRating
import com.example.moviedb.comman.utils.Constants
import com.example.moviedb.movieDetails.data.entity.MovieDetailsModel

@Composable
fun MovieDetailsScreen(movieDetailsModel: MovieDetailsModel,paddingValues: PaddingValues)
{
    Box {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            model = Constants.IMAGE_URL + movieDetailsModel.backdropPath,
            contentDescription = stringResource(id = R.string.movie_img),
            contentScale = ContentScale.Crop,
            alpha = 0.5f
        )
        /*Box (modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.Gray.copy(alpha = 0.5f))
        )*/
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    MovieCardImg(movieDetailsModel = movieDetailsModel)
                    MovieMainDetails(movieDetailsModel = movieDetailsModel)
                }
            }

            item {
                MovieGenres(movieDetailsModel = movieDetailsModel)
            }

            item {
                MovieDescription(movieDetailsModel.overview)
            }
        }
    }

}

@Preview
@Composable
fun DetailsScreenPreview()
{

}
@Composable
fun MovieCardImg(movieDetailsModel: MovieDetailsModel)
{
        Column (
            modifier = Modifier
                .padding(padding_16dp)
                .clip(RoundedCornerShape(corner_8dp))
                .background(color = blueDark),
        ){
            AsyncImage(
                modifier = Modifier.width(width_144dp),
                model = Constants.IMAGE_URL + movieDetailsModel.posterPath,
                contentDescription = stringResource(id = R.string.movie_img),
                contentScale = ContentScale.Crop

            )
            Row (
                modifier = Modifier
                    .padding(padding_8dp) ,
                horizontalArrangement = Arrangement.Center
            ){
                AsyncImage(
                    model = Constants.NETFLIX_IMAGE_URL,
                    contentDescription = stringResource(id = R.string.movie_img),
                    modifier = Modifier
                        .padding(padding_4dp)
                        .clip(RoundedCornerShape(corner_4dp))
                        .width(width_32dp)
                        .height(height_32dp),
                    contentScale = ContentScale.Crop

                )
                Column(
                    modifier = Modifier.padding(padding_4dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = stringResource(id = R.string.now_streaming),
                        color = Color.Gray,
                        fontSize = fontSize_10sp
                    )
                    Text(
                        text = stringResource(id = R.string.watch_now),
                        color = Color.White,
                        fontSize = fontSize_12sp

                    )
                }
            }
        }
}

@Composable
fun MovieMainDetails(movieDetailsModel: MovieDetailsModel) {
    Column(
        modifier = Modifier.padding(top = padding_16dp, end = padding_16dp)
    ) {
        Text(text = movieDetailsModel.title, fontSize = fontSize_24sp)
        Row {
            Text(text = movieDetailsModel.releaseDate)
            Text(text = stringResource(R.string.movie_language, movieDetailsModel.originalLanguage).uppercase())
        }
        MovieDetailsRating(rating = movieDetailsModel.voteAverage.toFloat())
        UserVibeView()
        Row(
            modifier = Modifier
                .padding(top = padding_16dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween

        ) {
            MovieIconAction(drawable = R.drawable.ic_menu)
            MovieIconAction(drawable = R.drawable.ic_favorite)
            MovieIconAction(drawable = R.drawable.ic_save)
        }
        PlayTrailerCompose()
    }
}

@Composable
fun MovieDetailsRating(rating:Float) {
    Row(
        modifier = Modifier.padding(top = padding_16dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        MovieRating(
            rating,
            Modifier
                .clip(
                    RoundedCornerShape(
                        topStartPercent = itemRoundedCornerShape,
                        topEndPercent = itemRoundedCornerShape,
                        bottomEndPercent = itemRoundedCornerShape,
                        bottomStartPercent = itemRoundedCornerShape
                    )
                )
        )
        Text(modifier = Modifier.padding(start = padding_8dp), text = "User Scour", fontSize = fontSize_16sp, lineHeight = lineHeight_16)
    }
}
@Composable
fun UserVibeView() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = padding_16dp)
            .clip(RoundedCornerShape(corner_16dp))
            .background(color = blueDark),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ){
        Text(
            modifier = Modifier
                .padding(start = padding_4dp),
            text = stringResource(id = R.string.what_your_vibe),
            color = Color.White
        )
        Icon(
            modifier = Modifier.padding(padding_8dp),
            painter = painterResource(id = R.drawable.ic_info),
            contentDescription = stringResource(id = R.string.info),
            tint = Color.White
        )
    }
}
@Composable
fun MovieIconAction(drawable:Int)
{
    IconButton(
        onClick = { },
        Modifier
            .clip(RoundedCornerShape(corner_20dp))
            .background(color = blueDark)
    ) {
        Icon(
            modifier = Modifier.padding(padding_8dp),
            painter = painterResource(id = drawable),
            contentDescription = stringResource(id = R.string.info),
            tint = Color.White
        )
    }
}
@Composable
fun MovieGenres(movieDetailsModel: MovieDetailsModel)
{
    Text(modifier = Modifier.padding(start = padding_16dp), fontSize = fontSize_24sp, text = stringResource(id = R.string.geners))
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = padding_16dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        items(movieDetailsModel.genres.size) { item ->
            Text(modifier = Modifier.padding(padding_4dp), text = movieDetailsModel.genres[item].name)
        }
    }
}
@Composable
fun PlayTrailerCompose()
{
    Row(
        modifier = Modifier
            .padding(top = padding_16dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center

    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_play),
            contentDescription = stringResource(R.string.info),
        )
        Text(text = stringResource(id = R.string.play_trailer))
    }
}

@Composable
fun MovieDescription(desc:String)
{
    Text(modifier = Modifier.padding(start = padding_16dp, top = padding_24dp), fontSize = fontSize_24sp, text = stringResource(id = R.string.desc))
    Text(modifier = Modifier.padding(start = padding_24dp, top = padding_8dp, end = padding_16dp), text = desc)
}

/*
private fun getDominantColor(bitmap: Bitmap): Color {
    val newBitmap = Bitmap.createScaledBitmap(bitmap, 1, 1, true)
    val color = newBitmap.getPixel(0, 0)
    newBitmap.recycle()
    return Color(color)
}*/
