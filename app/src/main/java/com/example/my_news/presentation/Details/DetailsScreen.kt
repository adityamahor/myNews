package com.example.my_news.presentation.Details

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.my_news.domain.model.Article
import com.example.my_news.domain.model.Source
import com.example.my_news.presentation.Details.component.DetailsTopBar
import com.example.my_news.utils.contants

@Composable
fun DetailsScreen (
    article: Article,
    event: (DetailsEvent) -> Unit,
    navigateUp: () -> Unit
){

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
    ) {

        DetailsTopBar(
            onBrowsingClick = {
                // by using Intent
                Intent(Intent.ACTION_VIEW).also {
                    it.data = Uri.parse(article.url)
                    if(it.resolveActivity(context.packageManager) != null){
                        context.startActivity(it)
                    }
                }
            },
            onShareClick = {
                Intent(Intent.ACTION_SEND).also {
                    it.putExtra(Intent.EXTRA_TEXT, article.url)
                    it.type = "text/plain"
                    if(it.resolveActivity(context.packageManager) != null){
                        context.startActivity(it)
                    }
                }
            },
            onBookmarkClick = {
                event(DetailsEvent.InsertDeleteArticle(article))
            },
            onBackClick = navigateUp
        )

        Spacer(modifier = Modifier.height(10.dp))

        LazyColumn (
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(
                start = contants.mediumpadding,
                end = contants.mediumpadding,
                top = contants.mediumpadding
            )
        ){

            item {
                AsyncImage(
                    model = ImageRequest.Builder(context).data(article.urlToImage).build(),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(248.dp)
                        .clip(MaterialTheme.shapes.medium),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.height(contants.mediumpadding))

                Text(
                    text = article.title,
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.Black,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = article.content,
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize = 17.sp,
                    maxLines = 4,
                    overflow = TextOverflow.Ellipsis,
                    color = Color.DarkGray,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun DeatailScreenprev() {

    DetailsScreen(
        article = Article(
            author = "",
            content = "Earlier this month, Apple CEO Tim Cook said the company would start importing iPhones manufactured in India to meet the majority of demand stateside. It seems U.S. President Donald Trump is not happy… [+1478 chars]",
            description = "",
            publishedAt = "2 hours",
            source = Source(id = "", name = "bbc"),
            title = "Trump tells Apple’s CEO to stop expanding iPhone production in India",
            url = "https://techcrunch.com/2025/05/15/trump-tells-apples-ceo-to-stop-expanding-iphone-production-in-india/",
            urlToImage = "https://techcrunch.com/wp-content/uploads/2024/01/iphone-15-getty.jpg?w=1200"
        ),
        event = {}
    ){

    }

}