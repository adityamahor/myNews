package com.example.my_news.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.basicMarquee
import com.example.my_news.R
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.paging.compose.LazyPagingItems
import com.example.my_news.domain.model.Article
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.my_news.presentation.common.ArticleList
import com.example.my_news.presentation.common.SearchBar

@Composable
fun HomeScreen (articles : LazyPagingItems<Article>,navigateTOSeach:()-> Unit,navigatoTODetail: (Article)-> Unit){

    val tittle by remember {
        derivedStateOf {
            if(articles.itemCount>10){
                articles.itemSnapshotList.items
                    .slice(IntRange(start = 0, endInclusive = 9))
                    .joinToString(separator = " \uD83d\uDFE5 ") { it.title }
            }else{
                ""
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
            .statusBarsPadding()
    ) {

        Image(
            painter = painterResource(id = R.drawable.news),
            contentDescription = null,
            modifier = Modifier
                .size(50.dp)
                .padding(8.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        SearchBar(
            modifier = Modifier.padding(horizontal = 10.dp),
            text = "",
            readOnly = true,
            onValueChange = {},
            onSearch = {},
            onClick = {
                navigateTOSeach()
            }
        )

        Spacer(modifier = Modifier.padding(8.dp))

        Text(
            text = tittle,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 5.dp)
                .basicMarquee(),
            fontSize = 12.sp,
            color = Color.DarkGray
        )

        Spacer(modifier = Modifier.padding(8.dp))


        ArticleList(
            modifier = Modifier.padding(horizontal = 5.dp),
            articles = articles,
            onClick = {
                navigatoTODetail(it)
            }
        )

    }
}