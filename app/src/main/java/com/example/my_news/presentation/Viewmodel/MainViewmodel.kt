package com.example.my_news.presentation.Viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.my_news.domain.usecase.app_entry.AllAppEntryUseCase
import com.example.my_news.presentation.Navgraph.Navgraphdata
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewmodel @Inject constructor(private val AllEntryUseCase: AllAppEntryUseCase) : ViewModel(){

    var splashCondition by mutableStateOf(true)
        private set

    var startDestination by mutableStateOf(Navgraphdata.AppStartNavigator.route)
        private set

    init {
        AllEntryUseCase.readEntry().onEach {
            if(it){
                startDestination = Navgraphdata.NewsNavigator.route
            }else{
                startDestination = Navgraphdata.AppStartNavigator.route
            }
            delay(300)
            splashCondition = false
        }.launchIn(viewModelScope)
    }

}