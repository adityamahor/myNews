package com.example.my_news.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.my_news.domain.usecase.news.NewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class homeViewmodel @Inject constructor(private val newsUseCase: NewsUseCase): ViewModel() {

        val news = newsUseCase.getNewsUseCase(
            sources = listOf("bbc-news","abc-news","al-jazeera-english", "google-news")
        ).cachedIn(viewModelScope)



}