package com.example.my_news.presentation.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.example.my_news.domain.model.Article


@Composable
fun ArticleList (
    modifier: Modifier = Modifier,
    articles: List<Article>,
    onClick:(Article) -> Unit
){

        LazyColumn(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(5.dp),
            contentPadding = PaddingValues(3.dp)
        ) {
            items(count = articles.size){
               val articles = articles[it]
                    NewsCard(onClick = {onClick(articles)}, article = articles)
            }
        }
}

@Composable
fun ArticleList (
    modifier: Modifier = Modifier,
    articles: LazyPagingItems<Article>,
    onClick:(Article) -> Unit
){

    val handelpagingresult = handlePagingResult(articles = articles)

    if(handelpagingresult){
        LazyColumn(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(5.dp),
            contentPadding = PaddingValues(3.dp)
        ) {
            items(count = articles.itemCount){
                articles[it]?.let {
                    NewsCard(onClick = {onClick(it)}, article = it)
                }
            }
        }
    }

}

@Composable
fun handlePagingResult(articles: LazyPagingItems<Article>) : Boolean{

    val loadState = articles.loadState
    val error = when{
        loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error
        loadState.append is LoadState.Error -> loadState.append as LoadState.Error
        loadState.prepend is LoadState.Error -> loadState.prepend as LoadState.Error
        else -> null
    }

    return when{
        loadState.refresh is LoadState.Loading -> {
            CallShimmer()
            false
        }

        error != null -> {
            EmptyScreen()
            false
        }

        else ->{
            true
        }
    }

}

@Composable
fun CallShimmer() {

    Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
        repeat(10){
            NewsCardshimmereffect()
        }
    }

}