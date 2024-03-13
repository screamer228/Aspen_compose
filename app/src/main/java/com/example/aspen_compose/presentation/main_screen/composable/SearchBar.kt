package com.example.aspen_compose.presentation.main_screen.composable

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aspen_compose.R

@Composable
fun SearchBar(modifier: Modifier) {
    var textState by remember { mutableStateOf("") }

    TextField(
        value = textState,
        onValueChange = { value -> textState = value },
        modifier = modifier,
        leadingIcon = {
            Icon(
                painterResource(R.drawable.ic_search),
                contentDescription = null,
                modifier = Modifier
                    .padding(
                        start = 8.dp
                    )
            )
        },
        placeholder = {
            Text(
                stringResource(R.string.find_things_to_do),
                modifier = Modifier
                    .padding(
                        vertical = 2.dp
                    ),
                fontSize = 14.sp,
                color = colorResource(R.color.gray),
                fontFamily = FontFamily(
                    Font(R.font.font_figtree_regular)
                )
            )
        },
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