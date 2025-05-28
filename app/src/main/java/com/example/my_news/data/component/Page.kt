package com.example.my_news.data.component

import androidx.annotation.DrawableRes
import com.example.my_news.R

data class Page(
    val tittle : String,
    val description: String,
    @DrawableRes val image : Int
)

val pages = listOf<Page>(

    Page("Lorem Ipsum is simple dummy",
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
        R.drawable.onboarding1),

    Page("Lorem Ipsum is simple dummy",
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
        R.drawable.onboarding2),

    Page("Lorem Ipsum is simple dummy",
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry\nLorem Ipsum is simply dummy text of the printing and typesetting industry.",
        R.drawable.onboarding3)

)
