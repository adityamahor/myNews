package com.example.my_news.presentation.news_navigator

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.my_news.domain.model.Article
import com.example.my_news.presentation.Details.DetailsEvent
import com.example.my_news.presentation.Details.DetailsScreen
import com.example.my_news.presentation.Details.DetailsViewmodel
import com.example.my_news.presentation.Navgraph.Navgraphdata
import com.example.my_news.presentation.Navgraph.Navgraphdata.SearchScreen
import com.example.my_news.presentation.bookMarks.BookMarkScreen
import com.example.my_news.presentation.bookMarks.BookMarkViewmodel
import com.example.my_news.presentation.home.HomeScreen
import com.example.my_news.presentation.home.homeViewmodel
import com.example.my_news.presentation.news_navigator.component.BottomNavigationItem
import com.example.my_news.presentation.news_navigator.component.BottumNavigationBarNews
import com.example.my_news.presentation.search.SearchSreen
import com.example.my_news.presentation.search.SearchViewmodel
import okhttp3.Route

@Composable
fun NewsNavigator (){

    val bottumNavigationItems  = remember {
        listOf(
            BottomNavigationItem(icon = Icons.Default.Home, text = "Home"),
            BottomNavigationItem(icon = Icons.Default.Search, text = "Search"),
            BottomNavigationItem(icon = Icons.Default.Bookmark, text = "Bookmark")
        )
    }

    val navController = rememberNavController()

    val backStakState = navController.currentBackStackEntryAsState().value
    var currentItem by rememberSaveable {
        mutableStateOf(0)
    }

    currentItem = remember(key1 = backStakState ) {
        when (backStakState?.destination?.route) {
            Navgraphdata.HomeScreen.route -> 0
            Navgraphdata.SearchScreen.route -> 1
            Navgraphdata.BookmarkScreen.route -> 2
            else -> 0
        }
    }

    val isbottombarvisible = remember(backStakState){
        backStakState?.destination?.route == Navgraphdata.HomeScreen.route ||
                backStakState?.destination?.route == Navgraphdata.SearchScreen.route ||
                backStakState?.destination?.route == Navgraphdata.BookmarkScreen.route
    }

    Scaffold(
        modifier = Modifier.fillMaxSize().background(Color.White),
        bottomBar = {
            if (isbottombarvisible) {
                BottumNavigationBarNews(
                    items = bottumNavigationItems,
                    selectedItem = currentItem,
                    onItemClick = { index ->
                        when (index) {
                            0 -> navigateUpTo(navController, Navgraphdata.HomeScreen.route)
                            1 -> navigateUpTo(navController, Navgraphdata.SearchScreen.route)
                            2 -> navigateUpTo(navController, Navgraphdata.BookmarkScreen.route)
                        }
                    }
                )
            }
        }
    ) {innerpadding->

        val bottumpadding = innerpadding.calculateBottomPadding()

        NavHost(
            navController = navController,
            startDestination = Navgraphdata.HomeScreen.route,
            modifier = Modifier.padding(bottom = bottumpadding)
        ){
            composable(Navgraphdata.HomeScreen.route) {
                val viewModel = hiltViewModel<homeViewmodel>()
                val articles = viewModel.news.collectAsLazyPagingItems()
                HomeScreen(
                    articles = articles,
                    navigateTOSeach = {
                        navigateUpTo(navController, Navgraphdata.SearchScreen.route)
                    },
                    navigatoTODetail = {
                        navigateUpToDetailed(navController,it)
                    }
                )
            }

            composable(Navgraphdata.SearchScreen.route){
                val viewModel = hiltViewModel<SearchViewmodel>()
                val state = viewModel.state.value
                SearchSreen(
                    searchStates = state,
                    searchEvent = viewModel::onEvent,
                    navigateToDeatails = {
                        navigateUpToDetailed(navController,it)
                    }
                )

            }

            composable(Navgraphdata.DetailScreen.route){
                val viewmodel = hiltViewModel<DetailsViewmodel>()
                if(viewmodel.sideEffect!=null){
                    Toast.makeText(LocalContext.current,viewmodel.sideEffect,Toast.LENGTH_SHORT).show()
                    viewmodel.onEvent(DetailsEvent.RemoveSideEffect)
                }
                navController.previousBackStackEntry?.savedStateHandle?.get<Article>("article")?.let {
                    DetailsScreen(
                        article = it,
                        event = viewmodel::onEvent,
                        navigateUp = {
                            navController.navigateUp()
                        }
                    )
                }

            }

            composable(Navgraphdata.BookmarkScreen.route){
                val viewmodel = hiltViewModel<BookMarkViewmodel>()
                val state = viewmodel.state.value
                BookMarkScreen(
                    state = state,
                    navigateUpTodetails = {
                        navigateUpToDetailed(navController,it)
                    }
                )
            }

        }

    }
}

private fun navigateUpTo(navController: NavController,route: String){
    navController.navigate(route){
        navController.graph.startDestinationRoute?.let {home->
            popUpTo(home){
                saveState = true
            }
            launchSingleTop = true
            restoreState = true

        }
    }
}

private fun navigateUpToDetailed(navController: NavController,article: Article){

    navController.currentBackStackEntry?.savedStateHandle?.set("article",article)
    navController.navigate(Navgraphdata.DetailScreen.route)

}