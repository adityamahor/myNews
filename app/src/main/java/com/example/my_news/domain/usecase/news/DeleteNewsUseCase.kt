package com.example.my_news.domain.usecase.news

import com.example.my_news.data.local.NewsDao
import com.example.my_news.domain.model.Article
import com.example.my_news.domain.repository.NewsRepository

class DeleteNewsUseCase (private val repository: NewsRepository) {

    suspend operator fun invoke(article: Article) {
        repository.deleteArticle(article)
    }

}