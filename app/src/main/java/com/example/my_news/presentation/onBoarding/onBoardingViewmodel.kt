package com.example.my_news.presentation.onBoarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.my_news.domain.usecase.app_entry.AllAppEntryUseCase
import com.example.my_news.presentation.OnboardingEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnboardingViewmodel @Inject constructor(
    private val allAppEntryUseCase: AllAppEntryUseCase
): ViewModel() {


    fun OnEvent(event: OnboardingEvent){
        when(event){
            is OnboardingEvent.SaveAppEntry -> {
                saveAppEntry()
            }
        }
    }

    private fun saveAppEntry(){
        viewModelScope.launch {
            allAppEntryUseCase.saveEntry()
        }
    }


}