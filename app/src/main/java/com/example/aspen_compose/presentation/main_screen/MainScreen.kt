package com.example.aspen_compose.presentation.main_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import com.example.aspen_compose.presentation.main_screen.composable.ButtonsLazyRow
import com.example.aspen_compose.presentation.main_screen.composable.PopularLazyRow
import com.example.aspen_compose.presentation.main_screen.composable.RecommendedLazyRow
import com.example.aspen_compose.presentation.main_screen.composable.SearchBar
import com.example.aspen_compose.presentation.main_screen.viewmodel.MainViewModel
import com.example.aspen_compose.utils.fillWidthOfParent

@Composable
fun MainScreen(
    viewModel: MainViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    navController: NavController
) {

    val uiState by viewModel.uiState.observeAsState(
        viewModel.getInitialState()
    )

    viewModel.getStateData()

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
        ButtonsLazyRow(
            modifier = Modifier
                .fillMaxWidth()
                //Custom Compose Util
                .fillWidthOfParent(20.dp)
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
                    top = 8.dp
                )
                //Custom Compose Util
                .fillWidthOfParent(20.dp),
            uiState.popularCardData,
            navController
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
                    top = 8.dp
                )
                //Custom Compose Util
                .fillWidthOfParent(20.dp),
            uiState.recommendedCardData
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
//    MainScreen(rememberNavController())
}

@Composable
fun ExploreAspen(modifier: Modifier) {
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
fun Location(modifier: Modifier) {
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
fun Popular(modifier: Modifier) {
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
fun SeeAll(modifier: Modifier) {
    Text(
        text = stringResource(R.string.see_all),
        modifier = modifier,
        color = colorResource(R.color.travel),
        fontWeight = FontWeight.SemiBold
    )
}

@Composable
fun Recommended(modifier: Modifier) {
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

