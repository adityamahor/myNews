package com.example.my_news.presentation.Navgraph

sealed class Navgraphdata(val route: String){

    object OnboardingScreen : Navgraphdata(route = "onboarding_screen")
    object HomeScreen : Navgraphdata(route = "home_screen")
    object SearchScreen : Navgraphdata(route = "search_screen")
    object BookmarkScreen : Navgraphdata(route = "bookmark_screen")
    object DetailScreen : Navgraphdata(route = "detail_screen")
    object AppStartNavigator : Navgraphdata(route = "app_start_navigator")
    object NewsNavigator : Navgraphdata(route = "news_navigator")
    object NewsNavigatorScreen : Navgraphdata(route = "news_navigator_screen")

}
