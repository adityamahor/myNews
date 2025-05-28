package com.example.my_news.presentation.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.my_news.domain.model.Article
import com.example.my_news.presentation.Navgraph.Navgraphdata
import com.example.my_news.presentation.common.ArticleList
import com.example.my_news.presentation.common.SearchBar

@Composable
fun SearchSreen (
    searchStates: SearchStates,
    searchEvent: (SearchEvent) -> Unit,
    navigateToDeatails: (Article) -> Unit
){

    Column(
        modifier = Modifier
            .padding(top = 8.dp, start = 8.dp, end = 8.dp)
            .statusBarsPadding()
            .fillMaxSize()
    ) {

        SearchBar(
            text = searchStates.searchQuery,
            readOnly = false,
            onValueChange = { searchEvent(SearchEvent.UpdateSearchQuery(it)) },
            onSearch = { searchEvent(SearchEvent.SearchNews) }
        )

        Spacer(modifier = Modifier.height(8.dp))

        searchStates.articles?.let {
            val articles = it.collectAsLazyPagingItems()
            ArticleList(articles = articles, onClick = {navigateToDeatails(it)})
        }

    }

}