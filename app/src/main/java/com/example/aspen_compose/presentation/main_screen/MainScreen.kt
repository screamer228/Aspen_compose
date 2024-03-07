package com.example.aspen_compose.presentation.main_screen

import SearchBar
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clipScrollableContainer
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.aspen_compose.R
import com.example.aspen_compose.ui.theme.Aspen_composeTheme
import com.example.aspen_compose.utils.fillWidthOfParent

@Composable
fun MainScreen(
//    navController: NavController
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                start = 20.dp,
                top = 40.dp,
                end = 20.dp
            )

    )
    {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        )
        {
            ExploreAspen(
                modifier = Modifier

            )
            Location(
                modifier = Modifier
            )
        }
        SearchBar(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 24.dp
                )
        )
        RowTonalButtons(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 32.dp
                )

        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 32.dp
                ),
            horizontalArrangement = Arrangement.SpaceBetween
        )
        {
            Popular(
                modifier = Modifier
            )
            SeeAll(
                modifier = Modifier
                    .align(Alignment.Bottom)
            )
        }
        PopularLazyRow(
            modifier = Modifier
                .padding(
                    top = 16.dp
                )
                .fillWidthOfParent(20.dp),
//            navController
        )
        Recommended(
            modifier = Modifier
                .padding(
                    top = 24.dp
                )
        )
        RecommendedLazyRow(
            modifier = Modifier
                .padding(
                    top = 12.dp
                )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMainScreen(){
    MainScreen()
}

@Composable
fun ExploreAspen(modifier : Modifier) {
    val textStyle = TextStyle(
        color = Color.Black,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily(
            Font(R.font.font_montserrat_regular)
        ),
    )
    Column(
        modifier = modifier
    )
    {
        Text(
            text = stringResource(R.string.explore),
            style = textStyle.copy(
                fontSize = 15.sp,
                fontWeight = FontWeight.Light
            ),
        )
        Text(
            text = stringResource(R.string.aspen),
            style = textStyle.copy(
                fontSize = 35.sp
            )
        )
    }
}

@Composable
fun Location(modifier: Modifier){
    val textStyle = TextStyle(
        color = colorResource(R.color.gray_hard),
        fontSize = 13.sp
    )

    Row(
        modifier = modifier
    )
    {
        Image(
            painter = painterResource(R.drawable.ic_location),
            modifier = Modifier
                .align(Alignment.CenterVertically),
            contentDescription = null
        )
        Text(
            text = stringResource(R.string.aspen_usa),
            modifier = Modifier
                .padding(
                    horizontal = 6.dp
                ),
            style = textStyle
        )
        Image(
            painter = painterResource(R.drawable.ic_arrow_down),
            modifier = Modifier
                .align(Alignment.CenterVertically),
            contentDescription = null
        )
    }
}

@Composable
fun RowTonalButtons(modifier: Modifier) {
    val buttonLabels = listOf(
        "Location",
        "Hotels",
        "Food",
        "Adventure",
        "Adventure"
    )
    var selectedButtonIndex by remember { mutableStateOf(0) }

    LazyRow(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    )
    {
        itemsIndexed(buttonLabels) { index, text ->
            FilledTonalButton(
                onClick = { selectedButtonIndex = index },
                modifier = Modifier
                    .height(40.dp)
                    .width(85.dp)
                    .selectable(
                        selected = index == selectedButtonIndex,
                        onClick = { selectedButtonIndex = index }
                    ),
                colors = ButtonDefaults.buttonColors(
                    containerColor =
                    if (index == selectedButtonIndex)
                        colorResource(R.color.gray_light)
                    else
                        Color.White,
                    contentColor = Color.White
                ),
                contentPadding = PaddingValues(0.dp)
            )
            {
                Text(
                    text = text,
                    modifier = Modifier,
                    fontSize = 14.sp,
                    color =
                    if (index == selectedButtonIndex)
                        colorResource(R.color.travel)
                    else
                        colorResource(R.color.gray),
                    fontWeight = if (index == selectedButtonIndex)
                        FontWeight.Bold
                    else
                        FontWeight.Normal
                )
            }
        }
    }
}

@Composable
fun Popular(modifier: Modifier){
    Text(
        text = stringResource(R.string.popular),
        modifier = modifier,
        fontSize = 20.sp,
        fontWeight = FontWeight.ExtraBold,
        fontFamily = FontFamily(
            Font(R.font.font_montserrat_regular)
        )
    )
}

@Composable
fun SeeAll(modifier: Modifier){
    Text(
        text = stringResource(R.string.see_all),
        modifier = modifier,
        color = colorResource(R.color.travel),
        fontWeight = FontWeight.SemiBold
    )
}

@Composable
fun Recommended(modifier: Modifier){
    Text(
        text = "Recommended",
        modifier = modifier,
        fontSize = 20.sp,
        fontWeight = FontWeight.ExtraBold,
        fontFamily = FontFamily(
            Font(R.font.font_montserrat_regular)
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecommendedLazyRow(modifier: Modifier){
    val dataList = listOf(
        PopularCardData(
            R.drawable.img_explore_aspen,
            stringResource(R.string.explore_aspen),
            "4N/5D"
        ),
        PopularCardData(
            R.drawable.img_luxurious_aspen,
            stringResource(R.string.luxurious_aspen),
            "2N/3D"
        )
    )

    LazyRow(
        modifier = modifier
    )
    {
        itemsIndexed(dataList) { index, item ->
            Card(
                onClick = {
//                          navController.navigate("detailScreen")
                },
                modifier = Modifier
                    .height(125.dp)
                    .width(200.dp)
                    .padding(
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
                        .border(
                            BorderStroke(1.dp, Color.White),
                            shape = RoundedCornerShape(20.dp)
                        )
                )
                {
                    Image(
                        painter = painterResource(item.imageId),
                        contentDescription = null,
                        modifier = Modifier
                            .height(100.dp)
                            .fillMaxWidth()
                            .border(
                                BorderStroke(1.dp, Color.White),
                                shape = RoundedCornerShape(20.dp)
                            )
                            .background(
                                Color.White,
                                shape = RoundedCornerShape(20.dp)
                            ),
                        contentScale = ContentScale.Crop,
                        alignment = Alignment.TopCenter
                    )
                    Text(
                        text = item.label,
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .padding(
                                start = 4.dp,
                                bottom = 4.dp
                            ),
                        fontWeight = FontWeight.Bold
                    )
                    Surface(
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .padding(
                                end = 6.dp,
                                bottom = 18.dp
                            ),
                        color = colorResource(R.color.gray_hard_label_surface),
                        shape = RoundedCornerShape(20.dp)
                    )
                    {
                        Text(
                            text = item.rating,
                            modifier = Modifier
                                .align(Alignment.Center)
                                .padding(4.dp),
                            color = Color.White,
                            fontSize = 10.sp
                        )
                    }
                }
            }
        }
    }
}