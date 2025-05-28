package com.example.my_news.presentation.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.HourglassEmpty
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun EmptyScreen (){

    Box(modifier = Modifier.fillMaxSize().padding(10.dp),
        contentAlignment = Alignment.Center){


        Icon(
            modifier = Modifier.size(150.dp),
            imageVector = Icons.Default.HourglassEmpty,
            contentDescription = null
        )


    }

}