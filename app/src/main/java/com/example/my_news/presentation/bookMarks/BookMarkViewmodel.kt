package com.example.my_news.presentation.bookMarks

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.my_news.domain.usecase.news.NewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class BookMarkViewmodel @Inject constructor(
    private val newsUseCase: NewsUseCase
) : ViewModel() {

    private val _state = mutableStateOf(BookMarkState())
    val state : State<BookMarkState> = _state

    init {
        getArticles()
    }

    private fun getArticles() {
        newsUseCase.selectNewsUseCase().onEach {
            _state.value = _state.value.copy(articles = it.asReversed())
        }.launchIn(viewModelScope)
    }

}