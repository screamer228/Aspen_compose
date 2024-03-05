package com.example.aspen_compose.presentation.main_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aspen_compose.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PopularLazyRow(modifier: Modifier) {
    val imageList = listOf(
        R.drawable.img_alley_palace,
        R.drawable.img_coeurdes_alpes
    )
    val labelList = listOf(
        "Alley Palace",
        "Coeurdes Alpes"
    )

    LazyRow(
        modifier = modifier
    )
    {
        itemsIndexed(imageList) { index, imageResource ->
            Card(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .height(300.dp)
                    .width(250.dp)
                    .padding(
                        16.dp
                    ),
                shape = RoundedCornerShape(24.dp)
            )
            {
                Box(
                    modifier = Modifier
                )
                {
                    Image(
                        painter = painterResource(imageResource),
                        contentDescription = null,
                        modifier = Modifier,
                        contentScale = ContentScale.Crop,
                        alignment = Alignment.TopCenter
                    )
                    Surface(
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .padding(
                                start = 12.dp,
                                bottom = 42.dp
                            ),
                        color = colorResource(R.color.gray_hard_label_surface),
                        shape = RoundedCornerShape(20.dp)
                    )
                    {
                        Text(
                            text = labelList[index],
                            modifier = Modifier
                                .padding(
                                    vertical = 4.dp,
                                    horizontal = 12.dp
                                ),
                            color = Color.White
                        )
                    }
                    Surface(
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .padding(
                                start = 12.dp,
                                bottom = 12.dp
                            ),
                        color = colorResource(R.color.gray_hard_label_surface),
                        shape = RoundedCornerShape(20.dp)
                    )
                    {
                        Row(
                            modifier = Modifier
                                .padding(
                                    vertical = 4.dp,
                                    horizontal = 12.dp
                                )
                        )
                        {
                            Icon(
                                painter = painterResource(R.drawable.ic_star_light),
                                contentDescription = null,
                                modifier = Modifier
                                    .align(Alignment.CenterVertically)
                                    .padding(
                                        end = 6.dp
                                    ),
                                tint = colorResource(R.color.yellow_star_light)
                            )
                            Text(
                                text = "4.1",
                                color = Color.White,
                                fontSize = 10.sp
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewRowPopular(){
    PopularLazyRow(Modifier)
}