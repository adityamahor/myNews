package com.example.my_news.domain.usecase.app_entry

data class AllAppEntryUseCase (
    val readEntry : getAppEntryUseCase,
    val saveEntry : saveAppEntryUseCase
)