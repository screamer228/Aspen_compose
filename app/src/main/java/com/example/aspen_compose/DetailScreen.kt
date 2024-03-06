package com.example.aspen_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aspen_compose.ui.theme.Aspen_composeTheme

class DetailScreenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Aspen_composeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}

@Composable
fun DetailScreen() {
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
                    .fillMaxWidth()
            )
            ArrowBack(
                modifier = Modifier
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
            CoeurdesAlpes(
                modifier = Modifier
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
                )
        )
        Description(
            modifier = Modifier
                .padding(
                    top = 12.dp,
                    end = 45.dp
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
                    top = 20.dp
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
                    .height(55.dp)
                    .width(240.dp)
                    .shadow(5.dp, RoundedCornerShape(16.dp))
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDetailScreen() {
    DetailScreen()
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
fun DetailCard(modifier: Modifier) {
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
                painter = painterResource(R.drawable.img_coeurdes_alpes),
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
fun CoeurdesAlpes(modifier: Modifier) {
    Text(
        text = stringResource(R.string.coeurdes_alpes),
        modifier = modifier,
        fontSize = 28.sp,
        fontWeight = FontWeight.SemiBold
    )
}

@Composable
fun ShowMap(modifier: Modifier) {
    Text(
        text = stringResource(R.string.show_map),
        modifier = modifier,
        color = colorResource(R.color.travel),
        fontWeight = FontWeight.SemiBold
    )
}

@Composable
fun RatingDetail(modifier: Modifier) {
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
            text = "4.5",
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
        modifier = modifier
    )
}

@Composable
fun ReadMore(modifier: Modifier) {
    Row(
        modifier = modifier
    )
    {
        Text(
            text = "Read more",
            color = colorResource(R.color.travel),
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
    Text(
        text = "Facilities",
        modifier = modifier,
        fontSize = 20.sp,
        fontWeight = FontWeight.SemiBold
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
            .height(70.dp)
            .width(75.dp)
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
                    top = 16.dp
                )
        )
        Text(
            text = text,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(
                    bottom = 16.dp
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
            fontWeight = FontWeight.SemiBold
        )
        Text(
            text = stringResource(R.string._199),
            modifier = Modifier,
            color = colorResource(R.color.green_dollars),
            fontSize = 24.sp,
            fontWeight = FontWeight.ExtraBold
        )
    }
}

@Composable
fun ButtonBookNow(modifier: Modifier) {
    Button(
        onClick = {

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
            fontSize = 18.sp
        )
        Image(
            painter = painterResource(R.drawable.ic_arrow_next),
            contentDescription = null
        )
    }
}
