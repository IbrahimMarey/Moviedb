package com.example.moviedb.comman.ui.customWidget

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import com.example.moviedb.comman.theme.banqueMisrColor
import com.example.moviedb.comman.theme.corner_8dp
import com.example.moviedb.comman.theme.fontSize_16sp
import com.example.moviedb.comman.theme.padding_8dp

@Composable
fun CustomText(txt:String,fontSize:TextUnit)
{
    Text(text = txt, fontSize = fontSize)
}

@Composable
fun GeneralText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Black,
    fontSize: TextUnit = fontSize_16sp,
    fontWeight: FontWeight = FontWeight.Normal,
    fontStyle: FontStyle = FontStyle.Normal,
    textAlign: TextAlign = TextAlign.Start,
    maxLines: Int = Int.MAX_VALUE,
    overflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        fontSize = fontSize,
        fontWeight = fontWeight,
        fontStyle = fontStyle,
        textAlign = textAlign,
        maxLines = maxLines,
        overflow = overflow,
        softWrap = softWrap,
        style = TextStyle(
            fontFamily = FontFamily.Default
        )
    )
}
@Composable
fun GeneralButton(
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = RoundedCornerShape(corner_8dp),
//    elevation: ButtonElevation? = ButtonDefaults.elevation(),
    border: BorderStroke? = null,
    colors: ButtonColors = ButtonDefaults.buttonColors(),
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    content: @Composable RowScope.() -> Unit= {}
) {
    Button(

        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        shape = shape,
//        elevation = elevation,
        border = border,
        colors = colors,
        contentPadding = contentPadding,
        content = content
    )
}

@Composable
fun CustomButton(txt:String = "Banque Misr",
                 padding:Dp = padding_8dp,
                 onClick: () -> Unit = {},
) {
    Button(
        modifier = Modifier
            .padding(padding)
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(containerColor = banqueMisrColor),
        shape = RoundedCornerShape(corner_8dp),
        onClick = onClick
    ) {
        Text(text = txt)
    }
}
@Preview
@Composable
fun TestPreview(){
    CustomButton()
}