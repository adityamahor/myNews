package com.example.my_news.domain.usecase.news

import com.example.my_news.data.local.NewsDao
import com.example.my_news.domain.model.Article
import com.example.my_news.domain.repository.NewsRepository
import retrofit2.http.Url

class SelectInsertDeleteUseCase(private val repository: NewsRepository) {

  suspend operator fun invoke(url: String) : Article? {
        return repository.getArticles(url)
    }

}