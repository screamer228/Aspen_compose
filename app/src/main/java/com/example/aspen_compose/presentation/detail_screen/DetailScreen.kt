package com.example.aspen_compose.presentation.detail_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.aspen_compose.R
import com.example.aspen_compose.presentation.common.TextMonserratSemiBold
import com.example.aspen_compose.presentation.detail_screen.viewmodel.DetailViewModel

@Composable
fun DetailScreen(
    viewModel: DetailViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    navController: NavController,
    index: Int
) {

    val uiState by viewModel.uiState.observeAsState(
        viewModel.getInitialState()
    )

    viewModel.getStateByIndex(index)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                20.dp
            )
    )
    {
        Box(
            modifier = Modifier
                .height(380.dp)
                .fillMaxWidth()
        )
        {
            DetailCard(
                modifier = Modifier
                    .height(355.dp)
                    .fillMaxWidth(),
                uiState.popularCardData.imageId
            )
            ArrowBack(
                modifier = Modifier
                    .clickable {
                        navController.navigateUp()
                    }
                    .height(50.dp)
                    .width(50.dp)
                    .padding(
                        start = 12.dp,
                        top = 12.dp
                    )
                    .background(
                        colorResource(R.color.gray_light),
                        shape = RoundedCornerShape(8.dp)
                    )
            )
            Favorite(
                modifier = Modifier
                    .height(45.dp)
                    .width(58.dp)
                    .align(Alignment.BottomEnd)
                    .padding(
                        end = 12.dp
                    )
                    .background(
                        colorResource(R.color.gray_favorite_bg),
                        shape = RoundedCornerShape(30.dp)
                    )
                    .shadow(4.dp, shape = RoundedCornerShape(30.dp))
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        )
        {
            Label(
                modifier = Modifier,
                uiState.popularCardData.label
            )
            ShowMap(
                modifier = Modifier
                    .align(Alignment.Bottom)
                    .padding(
                        bottom = 4.dp
                    )
            )
        }
        RatingDetail(
            modifier = Modifier
                .padding(
                    top = 8.dp
                ),
            uiState.popularCardData.rating
        )
        Description(
            modifier = Modifier
                .padding(
                    top = 12.dp,
                    end = 36.dp
                )
        )
        ReadMore(
            modifier = Modifier
                .padding(
                    top = 8.dp
                )
        )
        Facilities(
            modifier = Modifier
                .padding(
                    top = 22.dp
                )
        )
        FacilitiesImages(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 12.dp
                )
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 20.dp
                ),
            horizontalArrangement = Arrangement.SpaceBetween

        )
        {
            Price(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
            )
            ButtonBookNow(
                modifier = Modifier
                    .height(60.dp)
                    .width(240.dp)
                    .shadow(5.dp, RoundedCornerShape(16.dp))
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDetailScreen() {
//    DetailScreen(rememberNavController())
}

@Composable
fun ArrowBack(modifier: Modifier) {
    Box(
        modifier = modifier
    )
    {
        Image(
            painter = painterResource(R.drawable.ic_arrow_back_light),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.Center)
        )
    }
}

@Composable
fun DetailCard(modifier: Modifier, imageId: Int) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(24.dp)
    )
    {
        Box(
            modifier = Modifier
        )
        {
            Image(
                painter = painterResource(imageId),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.Crop,
                alignment = Alignment.TopCenter
            )
        }
    }
}

@Composable
fun Favorite(modifier: Modifier) {
    Surface(
        modifier = modifier
    )
    {
        Image(
            painter = painterResource(R.drawable.ic_heart),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    8.dp
                )
        )
    }
}

@Composable
fun Label(modifier: Modifier, label: String) {
    Text(
        text = label,
        modifier = modifier,
        fontSize = 25.sp,
        fontFamily = FontFamily(
            Font(R.font.font_montserrat_semibold)
        ),
        fontWeight = FontWeight.SemiBold
    )
}

@Composable
fun ShowMap(modifier: Modifier) {
    Text(
        text = stringResource(R.string.show_map),
        modifier = modifier,
        color = colorResource(R.color.travel),
        fontSize = 14.sp,
        fontWeight = FontWeight.SemiBold
    )
}

@Composable
fun RatingDetail(modifier: Modifier, rating: String) {
    Row(
        modifier = modifier
    )
    {
        Image(
            painter = painterResource(R.drawable.ic_star_dark),
            contentDescription = null,
            modifier = Modifier
        )
        Text(
            text = rating,
            modifier = Modifier
                .padding(
                    start = 4.dp,
                    end = 4.dp
                ),
            color = colorResource(R.color.gray_hard),
            fontSize = 13.sp
        )
        Text(
            text = "(355 Reviews)",
            modifier = Modifier,
            color = colorResource(R.color.gray_hard),
            fontSize = 13.sp
        )
    }
}

@Composable
fun Description(modifier: Modifier) {
    Text(
        text = stringResource(R.string.description_detail),
        modifier = modifier,
        fontSize = 14.sp,
        fontFamily = FontFamily(
            Font(R.font.font_figtree_regular)
        ),
        fontWeight = FontWeight.Medium,
        lineHeight = 20.sp
    )
}

@Composable
fun ReadMore(modifier: Modifier) {
    Row(
        modifier = modifier
    )
    {
        Text(
            text = stringResource(R.string.read_more),
            color = colorResource(R.color.travel),
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold
        )
        Image(
            painter = painterResource(R.drawable.ic_down_bold),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.Bottom)
                .padding(
                    start = 8.dp,
                    bottom = 4.dp
                )
        )
    }
}

@Composable
fun Facilities(modifier: Modifier) {
    TextMonserratSemiBold(
        modifier = modifier,
        text = stringResource(R.string.facilities)
    )
}

@Composable
fun FacilitiesImages(modifier: Modifier) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    )
    {
        Facility(
            imageId = R.drawable.ic_heater,
            text = stringResource(R.string._1_heater)
        )
        Facility(
            imageId = R.drawable.ic_dinner,
            text = stringResource(R.string.dinner)
        )
        Facility(
            imageId = R.drawable.ic_tub,
            text = stringResource(R.string._1_tub)
        )
        Facility(
            imageId = R.drawable.ic_pool,
            text = stringResource(R.string.pool)
        )
    }
}

@Composable
fun Facility(imageId: Int, text: String) {
    Box(
        modifier = Modifier
            .height(78.dp)
            .width(80.dp)
            .background(
                colorResource(R.color.gray_light),
                shape = RoundedCornerShape(16.dp)
            )
    )
    {
        Image(
            painter = painterResource(imageId),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(
                    top = 12.dp
                )
        )
        Text(
            text = text,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(
                    bottom = 12.dp
                ),
            color = colorResource(R.color.gray),
            fontSize = 11.sp
        )
    }
}

@Composable
fun Price(modifier: Modifier) {
    Column(
        modifier = modifier
    )
    {
        Text(
            text = stringResource(R.string.price),
            modifier = Modifier,
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold
        )
        Text(
            text = stringResource(R.string._199),
            modifier = Modifier,
            color = colorResource(R.color.green_dollars),
            fontSize = 24.sp,
            fontWeight = FontWeight.ExtraBold,
            fontFamily = FontFamily(
                Font(R.font.font_montserrat_semibold)
            )
        )
    }
}

@Composable
fun ButtonBookNow(modifier: Modifier) {
    Button(
        onClick = {
            TODO()
        },
        modifier = modifier,
        enabled = true,
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(
                id = R.color.travel
            )
        )
    )
    {
        Text(
            text = stringResource(R.string.book_now),
            modifier = Modifier
                .padding(
                    end = 15.dp
                ),
            fontSize = 17.sp,
            fontFamily = FontFamily(
                Font(R.font.font_figtree_semibold)
            )
        )
        Image(
            painter = painterResource(R.drawable.ic_arrow_next),
            contentDescription = null
        )
    }
}
