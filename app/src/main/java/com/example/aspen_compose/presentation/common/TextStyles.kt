package com.example.aspen_compose.presentation.common

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.aspen_compose.R

@Composable
fun TextMonserratSemiBold(modifier: Modifier, text: String) {
    Text(
        text = text,
        modifier = modifier,
        fontSize = 18.sp,
        fontFamily = FontFamily(
            Font(R.font.font_montserrat_semibold)
        ),
        fontWeight = FontWeight.ExtraLight
    )
}

@Composable
fun TextButtonSelected(modifier: Modifier, text: String) {
    Text(
        text = text,
        modifier = modifier,
        fontSize = 15.sp,
        color = colorResource(R.color.travel),
        fontFamily = FontFamily(
            Font(R.font.font_figtree_semibold)
        ),
        fontWeight = FontWeight.ExtraBold
    )
}

@Composable
fun TextButtonUnselected(modifier: Modifier, text: String) {
    Text(
        text = text,
        modifier = modifier,
        fontSize = 15.sp,
        color = colorResource(R.color.gray),
        fontFamily = FontFamily(
            Font(R.font.font_figtree_regular)
        ),
        fontWeight = FontWeight.ExtraLight
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewTextMonserratBold() {
    TextMonserratSemiBold(Modifier, "Popular")
}

@Preview(showBackground = true)
@Composable
fun PreviewTextButtonSelected() {
    TextButtonSelected(Modifier, "Location")
}

@Preview(showBackground = true)
@Composable
fun PreviewTextButtonUnselected() {
    TextButtonUnselected(Modifier, "Location")
}