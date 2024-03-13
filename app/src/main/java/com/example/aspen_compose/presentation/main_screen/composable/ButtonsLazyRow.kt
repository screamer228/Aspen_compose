package com.example.aspen_compose.presentation.main_screen.composable

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.aspen_compose.R
import com.example.aspen_compose.presentation.common.TextButtonSelected
import com.example.aspen_compose.presentation.common.TextButtonUnselected
import com.example.aspen_compose.utils.buttonPaddings

@Composable
fun ButtonsLazyRow(modifier: Modifier) {
    val buttonLabels = listOf(
        stringResource(R.string.location),
        stringResource(R.string.hotels),
        stringResource(R.string.food),
        stringResource(R.string.adventure),
        stringResource(R.string.adventure)
    )
    var selectedButtonIndex by remember { mutableIntStateOf(0) }

    LazyRow(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    )
    {
        itemsIndexed(buttonLabels) { index, text ->

            val paddings = buttonPaddings(index, buttonLabels.size)

            FilledTonalButton(
                onClick = { selectedButtonIndex = index },
                modifier = Modifier
                    .height(40.dp)
                    .padding(
                        start = paddings.paddingStart.dp,
                        end = paddings.paddingEnd.dp
                    )
                    .selectable(
                        selected = index == selectedButtonIndex,
                        onClick = { selectedButtonIndex = index }
                    ),
                colors = ButtonDefaults.buttonColors(
                    containerColor =
                    if (index == selectedButtonIndex)
                        colorResource(R.color.gray_light)
                    else
                        Color.Transparent
                ),
                contentPadding = PaddingValues(0.dp)
            )
            {
                if (index == selectedButtonIndex)
                    TextButtonSelected(
                        modifier = Modifier
                            .padding(
                                horizontal = 16.dp
                            ),
                        text = text
                    )
                else TextButtonUnselected(
                    modifier = Modifier
                        .padding(
                            horizontal = 16.dp
                        ),
                    text = text
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewButtonsLazyRow() {
    ButtonsLazyRow(Modifier)
}