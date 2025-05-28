package com.example.my_news.presentation.onBoarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun PageIndicator (
    modifier: Modifier = Modifier,
    pagesize: Int,
    selectedPage : Int,
    selectedColor: Color = Color.DarkGray,
    unselectedColor: Color = Color.LightGray
){

    Row (
        modifier = modifier , horizontalArrangement = Arrangement.SpaceBetween
    ){

        repeat(pagesize) {page->
            Box(
                modifier = Modifier.size(10.dp).clip(CircleShape)
                    .background(color = if(page==selectedPage) selectedColor else unselectedColor)
            )
        }

    }

}