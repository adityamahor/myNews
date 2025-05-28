package com.example.my_news.domain.usecase.news

data class NewsUseCase(
    val getNewsUseCase: GetNewsUseCase,
    val searchNewsUseCase: searchNewsUseCase,
    val insertNewsUseCase: InsertNewsUseCase,
    val deleteNewsUseCase: DeleteNewsUseCase,
    val selectNewsUseCase: SelectNewsUseCase,
    val selectInsertDeleteUseCase : SelectInsertDeleteUseCase
)