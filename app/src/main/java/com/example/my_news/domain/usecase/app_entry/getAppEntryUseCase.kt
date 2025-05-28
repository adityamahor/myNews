package com.example.my_news.domain.usecase.app_entry

import com.example.my_news.domain.manager.localUsermanager
import kotlinx.coroutines.flow.Flow

class getAppEntryUseCase(
    val localUsermanager: localUsermanager
){

    operator fun invoke(): Flow<Boolean>{
        return localUsermanager.readAppEntry()
    }

}