package com.example.my_news.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.my_news.domain.model.Article

class NewsPaggingSource(
    private val newsApi: NewsApi,
    private val sources: String
) : PagingSource<Int, Article>(){

   private var totalnewsCount = 0

    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        return state.anchorPosition?.let {
            val anchorpage = state.closestPageToPosition(it)
            anchorpage?.prevKey?.plus(1)?: anchorpage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {

        val page = params.key ?: 1

        return try {
            val newresponse = newsApi.getNews(page,sources)
            totalnewsCount += newresponse.articles.size
            val articles = newresponse.articles.distinctBy { it.title }
            LoadResult.Page(
                data = articles,
                nextKey = if(totalnewsCount == newresponse.totalResults) null else page + 1,
                prevKey = null
            )
        }catch (e: Exception){
            e.printStackTrace()
            LoadResult.Error(
                throwable = e
            )
        }

    }


}