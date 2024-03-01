package com.example.aspen_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.aspen_compose.ui.theme.Aspen_composeTheme
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Aspen_composeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyScreen()
                }
            }
        }
    }
}

@Composable
fun MyScreen() {
    Box(
        modifier = Modifier.fillMaxSize()
    )
    {
        Image(
            painterResource(id = R.drawable.background),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            alignment = Alignment.CenterEnd
        )
        AspenGreeting(modifier = Modifier
            .align(Alignment.TopCenter)
            .padding(
                top = 80.dp
            )
        )
        PlanYourVacation(modifier = Modifier
            .align(Alignment.BottomStart)
            .padding(
                start = 30.dp,
                bottom = 120.dp
            )
        )
        ButtonExplore(modifier = Modifier
            .height(100.dp)
            .fillMaxWidth()
            .align(Alignment.BottomCenter)
            .padding(
                start = 30.dp,
                end = 30.dp,
                bottom = 45.dp
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMyScreen(){
    MyScreen()
}

@Composable
fun AspenGreeting(modifier: Modifier) {
    val textStyle = TextStyle(
        fontFamily = FontFamily(
            Font(R.font.font_hiatus)
        ),
        color = Color.White,
        fontSize = 140.sp
    )
    Text(
        text = "Aspen",
        modifier = modifier,
        style = textStyle
    )
}

@Preview(showBackground = false)
@Composable
fun PreviewAspenGreeting() {
    AspenGreeting(Modifier)
}

@Composable
fun PlanYourVacation(modifier: Modifier)
{
    val textStyle = TextStyle(
        fontWeight = FontWeight.ExtraBold,
        fontFamily = FontFamily(
            Font(R.font.font_montserrat_bold)
        ),
        color = Color.White
    )
    Column(
        modifier = modifier
    ) {
        Text(
            text = "Plan your",
            style = textStyle.copy(fontSize = 24.sp),
        )
        Text(
            text = "Luxurious",
            style = textStyle.copy(fontSize = 40.sp)
        )
        Text(
            text = "Vacation",
            style = textStyle.copy(fontSize = 40.sp)
        )
    }
}

@Preview
@Composable
fun PreviewPlanYourVacation(){
    PlanYourVacation(Modifier)
}

@Composable
fun ButtonExplore(modifier: Modifier){
    Button(
        onClick = {
                     /*TODO*/
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
            text = "Explore"
        )
    }
}

@Preview
@Composable
fun PreviewButtonExplore(){
    ButtonExplore(Modifier)
}