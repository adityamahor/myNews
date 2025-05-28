package com.example.my_news.presentation.Details

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.my_news.domain.model.Article
import com.example.my_news.domain.usecase.news.NewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewmodel @Inject constructor(
    private val newsUseCase: NewsUseCase
) : ViewModel() {

    var sideEffect by mutableStateOf<String?>(null)
        private set

    fun onEvent(event: DetailsEvent){
        when(event){
            is DetailsEvent.InsertDeleteArticle -> {
                viewModelScope.launch {
                    val article = newsUseCase.selectInsertDeleteUseCase(event.article.url)
                    if(article == null){
                        insertArticle(event.article)
                    }else{
                        deleteArticle(event.article)
                    }
                }
            }

            is DetailsEvent.RemoveSideEffect -> {
                sideEffect = null
            }

        }
    }

    private suspend fun deleteArticle(article: Article) {
        newsUseCase.deleteNewsUseCase(article)
        sideEffect = "Article Deleted"
    }

    private suspend fun insertArticle(article: Article) {
        newsUseCase.insertNewsUseCase(article)
        sideEffect = "Article Inserted"
    }

}