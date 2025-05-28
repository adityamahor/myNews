package com.example.my_news.data.remote.dto

import com.example.my_news.domain.model.Article

data class newsRespoonse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)