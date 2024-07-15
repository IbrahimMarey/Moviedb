package com.example.moviedb.comman.ui.customWidget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.moviedb.R
import com.example.moviedb.comman.theme.blueDark
import com.example.moviedb.comman.theme.corner_20dp
import com.example.moviedb.comman.theme.padding_8dp

@Composable
fun CustomIconBtn(drawable:Int,)
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