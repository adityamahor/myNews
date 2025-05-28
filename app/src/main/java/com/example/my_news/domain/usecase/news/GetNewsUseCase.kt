package com.example.my_news.domain.usecase.news

import androidx.paging.PagingData
import com.example.my_news.domain.model.Article
import com.example.my_news.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetNewsUseCase(
    private val repository: NewsRepository
) {

    operator fun invoke(sources: List<String>): Flow<PagingData<Article>> {
        return repository.getNews(sources)
    }

}