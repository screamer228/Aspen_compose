package com.example.aspen_compose.presentation.common

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun TextRed(modifier : Modifier)
{
    Text(
        text = "",
        modifier = modifier
    )
}

@Composable
fun Text16RedBold(modifier: Modifier)
{
    TextRed(
        modifier = modifier
    )
}