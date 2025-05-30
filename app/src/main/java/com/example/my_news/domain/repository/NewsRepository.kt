package com.example.my_news.domain.repository

import androidx.paging.PagingData
import com.example.my_news.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    fun getNews(sources: List<String>) : Flow<PagingData<Article>>

    fun searchNews(searchQuery: String, sources: List<String>) : Flow<PagingData<Article>>

    suspend fun InsertArticle(article: Article)

    suspend fun deleteArticle(article: Article)

    fun getArticles(): Flow<List<Article>>

    suspend fun getArticles(url: String) : Article?

}