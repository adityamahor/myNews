package com.example.my_news.presentation.onBoarding

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun NewsButton (
    text: String,
    onClick: () -> Unit
){


   Button(
        onClick = onClick, colors = ButtonDefaults.buttonColors(
            containerColor = Color.DarkGray,
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(10.dp)
    ) {

        Text(
            text = text,
            textAlign = TextAlign.Center,
            color = Color.White,
            fontWeight = FontWeight.SemiBold
        )

    }

}

@Composable
fun NewsNextButton(
    text: String,
    onClick: () -> Unit
) {

    TextButton(onClick = onClick){

        Text(
            text = text,
            textAlign = TextAlign.Center,
            color = Color.DarkGray,
            fontWeight = FontWeight.SemiBold
        )

    }
    
}

@Preview(showBackground = true,showSystemUi = true)
@Composable
private fun preButton() {

    NewsButton(text = "Button", onClick = {})

}