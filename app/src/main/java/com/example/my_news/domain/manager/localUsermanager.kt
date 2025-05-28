package com.example.my_news.domain.manager

import kotlinx.coroutines.flow.Flow

interface localUsermanager {

    suspend fun saveAppEntry()

    fun readAppEntry() : Flow<Boolean>

}