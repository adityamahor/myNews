package com.example.my_news.presentation.search

import androidx.paging.PagingData
import com.example.my_news.domain.model.Article
import kotlinx.coroutines.flow.Flow

data class SearchStates (
    val searchQuery: String = "",
    val articles: Flow<PagingData<Article>>? = null
)