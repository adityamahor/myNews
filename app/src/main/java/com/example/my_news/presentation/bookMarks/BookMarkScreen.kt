package com.example.my_news.presentation.bookMarks

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.my_news.domain.model.Article
import com.example.my_news.presentation.Navgraph.Navgraphdata
import com.example.my_news.presentation.common.ArticleList

@Composable
fun BookMarkScreen(
    state: BookMarkState,
    navigateUpTodetails: (Article) -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(top = 10.dp, start = 10.dp, end = 10.dp)
    ) {

        Text(
            text = "Bookmarks",
            fontWeight = FontWeight.SemiBold,
            color = Color.Black,
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(15.dp))

        ArticleList(
            articles = state.articles,
            onClick = {
                navigateUpTodetails(it)
            }
        )

    }


}