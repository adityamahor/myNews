package com.example.my_news.domain.usecase.news

import androidx.paging.PagingData
import com.example.my_news.domain.model.Article
import com.example.my_news.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class searchNewsUseCase(private val repository: NewsRepository) {

    operator fun invoke(searchQuery: String, sources: List<String>): Flow<PagingData<Article>> {
        return repository.searchNews(searchQuery, sources)
    }

}