package com.example.my_news.domain.usecase.news

import com.example.my_news.data.local.NewsDao
import com.example.my_news.domain.model.Article
import com.example.my_news.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class SelectNewsUseCase (private val repository: NewsRepository) {

    operator fun invoke(): Flow<List<Article>> {
        return repository.getArticles()
    }

}