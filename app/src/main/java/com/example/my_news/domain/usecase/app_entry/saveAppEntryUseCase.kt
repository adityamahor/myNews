package com.example.my_news.domain.usecase.app_entry

import com.example.my_news.domain.manager.localUsermanager

class saveAppEntryUseCase(
    val localUsermanager: localUsermanager
){

    suspend operator fun invoke(){
        localUsermanager.saveAppEntry()
    }

}