package com.example.my_news.presentation.search

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.my_news.domain.usecase.news.NewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewmodel @Inject constructor(
    private val newsUseCase: NewsUseCase
) : ViewModel() {

    // states
    private val _state = mutableStateOf(SearchStates())
    val state: State<SearchStates> = _state

    fun onEvent(event: SearchEvent){
        when(event){

            is SearchEvent.UpdateSearchQuery -> {
                _state.value = state.value.copy(searchQuery = event.searchQuery)
            }

            is SearchEvent.SearchNews -> {
                searchNews()
            }

        }
    }

    // also include abp news and ajjtak news source
    private fun searchNews() {
        val articles = newsUseCase.searchNewsUseCase(
            state.value.searchQuery,
            listOf("bbc-news", "abc-news", "al-jazeera-english", "google-news")
        ).cachedIn(viewModelScope)
        _state.value = state.value.copy(articles = articles)
    }

}