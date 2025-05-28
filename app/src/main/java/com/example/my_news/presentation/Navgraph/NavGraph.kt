package com.example.my_news.presentation.Navgraph

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.my_news.presentation.bookMarks.BookMarkScreen
import com.example.my_news.presentation.bookMarks.BookMarkViewmodel
import com.example.my_news.presentation.news_navigator.NewsNavigator
import com.example.my_news.presentation.onBoarding.OnboardingViewmodel
import com.example.my_news.presentation.onBoarding.OnBoardingScreen
import com.example.my_news.presentation.search.SearchSreen
import com.example.my_news.presentation.search.SearchViewmodel

@Composable
fun NavGraph(startDestination: String) {

    val navController = rememberNavController()

    NavHost(navController,startDestination){
        navigation(
            route = Navgraphdata.AppStartNavigator.route,
            startDestination = Navgraphdata.OnboardingScreen.route
        ) {
            composable(Navgraphdata.OnboardingScreen.route) {
                val viewmodel: OnboardingViewmodel = hiltViewModel()
                OnBoardingScreen(
                    event = viewmodel::OnEvent
                )
            }
        }

        navigation(
            route = Navgraphdata.NewsNavigator.route,
            startDestination = Navgraphdata.NewsNavigatorScreen.route
        ) {
            composable(Navgraphdata.NewsNavigatorScreen.route) {
                NewsNavigator()
            }
        }

    }

}