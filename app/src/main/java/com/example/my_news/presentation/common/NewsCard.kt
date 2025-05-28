package com.example.my_news.presentation.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import com.example.my_news.R
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.my_news.domain.model.Article
import com.example.my_news.domain.model.Source

@Composable
fun NewsCard (
    modifier: Modifier = Modifier,
    onClick:()-> Unit,
    article: Article
){

    val context = LocalContext.current

    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(R.color.whitelight)
        )
    ) {

        Row (modifier = Modifier.clickable{onClick()}){

            AsyncImage(
                modifier = Modifier
                    .padding(5.dp)
                    .size(100.dp)
                    .clip(MaterialTheme.shapes.medium),
                model = ImageRequest.Builder(context).data(article.urlToImage).build(),
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )


            Column(verticalArrangement = Arrangement.SpaceAround,
                modifier = Modifier.padding(horizontal = 5.dp)
                    .height(100.dp)) {

                Text(text = article.title,
                    style = TextStyle(
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black,
                        fontSize = 17.sp
                    ),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis)

                Row (verticalAlignment = Alignment.CenterVertically){

                    Text(
                        text = article.source.name,
                        style = TextStyle(
                            fontWeight = FontWeight.SemiBold,
                            color = Color.DarkGray,
                            fontSize = 15.sp
                        )
                    )

                    Spacer(modifier = Modifier.width(6.dp))


                    Icon(
                        modifier = Modifier.size(18.dp),
                        painter = painterResource(id = R.drawable.baseline_access_time_24),
                        contentDescription = null,
                    )

                    Spacer(modifier = Modifier.width(6.dp))

                    Text(
                        text = article.publishedAt,
                        style = TextStyle(
                            fontWeight = FontWeight.SemiBold,
                            color = Color.DarkGray,
                            fontSize = 13.sp
                        )
                    )

                }

            }

        }

    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun prev() {
    NewsCard(
        onClick = { /*TODO*/ },
        article = Article(
            author = "",
            content = "",
            description = "",
            publishedAt = "2 hours",
            source = Source(id = "", name = "bbc"),
            title = "Lorem Ipsum is simply dummy text of the printing and typesetting industry",
            url = "",
            urlToImage = ""
        )
    )
}