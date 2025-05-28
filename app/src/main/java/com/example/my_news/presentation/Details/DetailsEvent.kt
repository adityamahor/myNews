package com.example.my_news.presentation.Details

import com.example.my_news.domain.model.Article

sealed class DetailsEvent{
    // only save
    data class InsertDeleteArticle(val article: Article) : DetailsEvent()

    object RemoveSideEffect : DetailsEvent()

}
