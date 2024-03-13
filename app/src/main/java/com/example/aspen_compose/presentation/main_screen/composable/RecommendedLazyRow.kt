package com.example.aspen_compose.presentation.main_screen.composable

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aspen_compose.R
import com.example.aspen_compose.presentation.model.RecommendedCardData
import com.example.aspen_compose.utils.itemLazyRowPadding

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecommendedLazyRow(
    modifier: Modifier,
    recommendedCardData: MutableList<RecommendedCardData>
) {

    LazyRow(
        modifier = modifier
    )
    {
        itemsIndexed(recommendedCardData) { index, item ->
            Card(
                onClick = {
                    TODO()
                },
                modifier = Modifier
                    .height(125.dp)
                    .width(220.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .padding(
                        start = itemLazyRowPadding(index).dp,
                        end = 20.dp
                    ),
                shape = RoundedCornerShape(12.dp),
                elevation = CardDefaults.cardElevation(8.dp)
            )
            {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White)
                )
                {
                    Image(
                        painter = painterResource(item.imageId),
                        contentDescription = null,
                        modifier = Modifier
                            .height(100.dp)
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(20.dp))
                            .padding(2.dp),
                        contentScale = ContentScale.Crop,
                        alignment = Alignment.BottomCenter
                    )
                    Text(
                        text = item.label,
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .padding(
                                start = 4.dp,
                                bottom = 4.dp
                            ),
                        fontSize = 13.sp,
                        fontFamily = FontFamily(
                            Font(R.font.font_figtree_semibold)
                        ),
                        fontWeight = FontWeight.ExtraBold
                    )
                    Surface(
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .padding(
                                end = 6.dp,
                                bottom = 16.dp
                            ),
                        color = colorResource(R.color.gray_hard_label_surface),
                        shape = RoundedCornerShape(20.dp),
                        border = BorderStroke(1.dp, Color.White)
                    )
                    {
                        Text(
                            text = item.duration,
                            modifier = Modifier
                                .align(Alignment.Center)
                                .padding(
                                    horizontal = 6.dp,
                                    vertical = 2.dp

                                ),
                            color = Color.White,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewRecommendedLazyRow() {
//    RecommendedLazyRow(Modifier)
}