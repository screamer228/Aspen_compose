package com.example.aspen_compose.presentation.main_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
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
import com.example.aspen_compose.R
import com.example.aspen_compose.ui.theme.Aspen_composeTheme

@Composable
fun MainScreen(onNavigateToDetailScreen: () -> Unit){
    Box(
        modifier = Modifier
            .fillMaxSize()

            .background(colorResource(R.color.white))
    )
    {
        ExploreAspen(
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(
                    start = 16.dp,
                    top = 32.dp
                )
        )
        Location(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(
                    top = 32.dp,
                    end = 16.dp
                )
        )
        SearchBar(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
                .padding(
                    top = 125.dp
                )
        )
        RowTonalButtons(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
                .padding(
                    start = 16.dp,
                    top = 205.dp,
                    end = 16.dp
                )
        )
        Popular(
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(
                    start = 16.dp,
                    top = 280.dp
                )
        )
        SeeAll(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(
                    top = 286.dp,
                    end = 16.dp
                )
        )
        PopularLazyRow(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(
                    top = 300.dp
                ),
            onNavigateToDetailScreen
        )
    }
}

//@Preview
//@Composable
//fun PreviewMainScreen(){
//    MainScreen()
//}

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

@Preview(showBackground = true)
@Composable
fun ExploreAspenPreview() {
    Aspen_composeTheme {
        ExploreAspen(Modifier)
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

@Preview(showBackground = true)
@Composable
fun PreviewLocation() {
    Location(Modifier)
}

@Composable
fun SearchBar(modifier: Modifier) {
    var textState by remember { mutableStateOf("") }

    TextField(
        value = textState,
        onValueChange = { value -> textState = value },
        modifier = modifier
            .padding(
                horizontal = 16.dp
            ),
        leadingIcon = {
            Icon(
                painterResource(R.drawable.ic_search),
                contentDescription = null
            ) },
        placeholder = {
            Text(
                stringResource(R.string.find_things_to_do),
                color = colorResource(R.color.gray)
            ) },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = colorResource(R.color.gray_light),
            unfocusedContainerColor = colorResource(R.color.gray_light),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            focusedLeadingIconColor = colorResource(R.color.gray),
            unfocusedLeadingIconColor = colorResource(R.color.gray),
            unfocusedSupportingTextColor = colorResource(R.color.gray),
        ),
        singleLine = true,
        shape = RoundedCornerShape(24.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewSearchBar(){
    SearchBar(Modifier)
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
                    .height(55.dp)
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
            )
            {
                Text(
                    text = text,
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