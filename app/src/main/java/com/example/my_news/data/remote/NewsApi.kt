package com.example.my_news.data.remote

import com.example.my_news.data.remote.dto.newsRespoonse
import com.example.my_news.utils.contants
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("everything")
    suspend fun getNews(
        @Query("page") page: Int,
        @Query("sources") string: String,
        @Query("apiKey") apiKey: String = contants.API_KEY
    ): newsRespoonse

    @GET("everything")
    suspend fun searchNews(
        @Query("q") searchQuery: String,
        @Query("page") page: Int,
        @Query("sources") string: String,
        @Query("apiKey") apiKey: String = contants.API_KEY
    ): newsRespoonse

}