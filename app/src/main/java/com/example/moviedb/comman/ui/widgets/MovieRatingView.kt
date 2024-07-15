package com.example.moviedb.comman.ui.widgets

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import com.example.moviedb.R
import com.example.moviedb.comman.theme.fontSize_12sp

@Composable
fun MovieRating(progress: Float, modifier: Modifier) {
    val rate: Float by remember { mutableFloatStateOf(progress) }

    Card(
        modifier = modifier
    ) {
        Box(contentAlignment = Alignment.Center) {
            CircularProgressIndicator(
                progress = rate/10,
                trackColor = Color.Gray,
                color = Color.Green
            )
            Text(

                text = stringResource(
                    id = R.string.movie_percentage_rate,
                    (rate * 10).toInt()),
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = fontSize_12sp
                ),
                modifier = Modifier.align(Alignment.Center),
            )
        }
    }
}