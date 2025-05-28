package com.example.my_news.presentation.bookMarks

import com.example.my_news.domain.model.Article

data class BookMarkState(
    val articles: List<Article> = emptyList(),
)
