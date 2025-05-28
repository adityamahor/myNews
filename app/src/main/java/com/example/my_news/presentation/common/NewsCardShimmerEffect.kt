package com.example.my_news.presentation.common

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.my_news.R


@Composable
fun NewsCardshimmereffect(){

    val shimmercolor = listOf(
        colorResource(R.color.whitelight).copy(0.6f),
        colorResource(R.color.whitelight).copy(0.2f),
        colorResource(R.color.whitelight).copy(0.6f)
    )

    val transition = rememberInfiniteTransition()
    val animatedtransition  = transition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec  = infiniteRepeatable(
            animation = tween(
                durationMillis = 1000,
                easing = FastOutSlowInEasing
            )
        ),
        label = ""
    )

    val brush = Brush.linearGradient(
        colors = shimmercolor,
        start = Offset(5f,5f),
        end = Offset(animatedtransition.value,animatedtransition.value)
    )

    // shimmer item grid

    NewsCardshimmerGrid(brush = brush)

}

@Composable
fun NewsCardshimmerGrid(brush: Brush) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.LightGray
        ),
        shape = RoundedCornerShape(10.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(all = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Spacer(
                modifier = Modifier
                    .size(100.dp)
                    .clip(
                        RoundedCornerShape(8.dp)
                    )
                    .background(brush)
            )

            Spacer(modifier = Modifier.padding(10.dp))

            Column(
                verticalArrangement = Arrangement.SpaceAround,
                modifier = Modifier.height(100.dp)
            ) {

                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(30.dp)
                        .clip(RoundedCornerShape(5.dp))
                        .background(brush)
                )

                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(15.dp)
                        .clip(RoundedCornerShape(5.dp))
                        .background(brush)
                )

            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun prevshimmer() {

    NewsCardshimmerGrid(brush = Brush.linearGradient(
        listOf(Color.White, Color.LightGray, Color.White)))

}