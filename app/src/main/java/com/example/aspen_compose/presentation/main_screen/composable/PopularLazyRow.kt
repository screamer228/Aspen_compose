package com.example.aspen_compose.presentation.main_screen.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.aspen_compose.R
import com.example.aspen_compose.navigation.ROUTE_DETAIL_SCREEN
import com.example.aspen_compose.presentation.model.PopularCardData
import com.example.aspen_compose.utils.itemLazyRowPadding

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PopularLazyRow(
    modifier: Modifier,
    popularCardData: List<PopularCardData>,
    navController: NavController
) {

    LazyRow(
        modifier = modifier
    )
    {
        itemsIndexed(popularCardData) { index, item ->
            Card(
                onClick = {
                    navController.navigate(
                        "$ROUTE_DETAIL_SCREEN$index"
                    )
                },
                modifier = Modifier
                    .height(260.dp)
                    .width(240.dp)
                    .padding(
                        start = itemLazyRowPadding(index).dp,
                        end = 20.dp
                    ),
                shape = RoundedCornerShape(24.dp)
            )
            {
                Box(
                    modifier = Modifier
                )
                {
                    Image(
                        painter = painterResource(item.imageId),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxSize(),
                        contentScale = ContentScale.Crop,
                        alignment = Alignment.TopCenter
                    )
                    Surface(
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .padding(
                                start = 14.dp,
                                bottom = 44.dp
                            ),
                        color = colorResource(R.color.gray_hard_label_surface),
                        shape = RoundedCornerShape(20.dp)
                    )
                    {
                        Text(
                            text = item.label,
                            modifier = Modifier
                                .align(Alignment.Center)
                                .padding(
                                    vertical = 4.dp,
                                    horizontal = 11.dp
                                ),
                            color = Color.White,
                            fontSize = 13.sp,
                            fontFamily = FontFamily(
                                Font(R.font.font_figtree_regular)
                            )
                        )
                    }
                    Surface(
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .padding(
                                start = 14.dp,
                                bottom = 14.dp
                            ),
                        color = colorResource(R.color.gray_hard_label_surface),
                        shape = RoundedCornerShape(20.dp)
                    )
                    {
                        Row(
                            modifier = Modifier
                                .padding(
                                    vertical = 5.dp,
                                    horizontal = 11.dp
                                )
                        )
                        {
                            Image(
                                painter = painterResource(R.drawable.ic_star_light),
                                contentDescription = null,
                                modifier = Modifier
                                    .align(Alignment.CenterVertically)
                                    .padding(
                                        end = 6.dp
                                    )
                            )
                            Text(
                                text = item.rating,
                                color = Color.White,
                                fontSize = 11.sp,
                                fontFamily = FontFamily(
                                    Font(R.font.font_figtree_regular)
                                )
                            )
                        }
                    }
                    Surface(
                        modifier = if (item.isFavorite)
                            Modifier
                                .height(40.dp)
                                .width(40.dp)
                                .align(Alignment.BottomEnd)
                                .padding(
                                    end = 14.dp,
                                    bottom = 14.dp
                                )
                                .background(
                                    colorResource(R.color.gray_favorite_bg),
                                    shape = RoundedCornerShape(30.dp)
                                )
                                .clip(shape = RoundedCornerShape(30.dp))
                        else
                            Modifier
                                .size(0.dp)
                    )
                    {
                        Image(
                            painter = painterResource(R.drawable.ic_heart),
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxSize()
                                .align(Alignment.Center)
                                .padding(
                                    5.dp
                                )
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewRowPopular() {
//    PopularLazyRow(Modifier, rememberNavController())
}