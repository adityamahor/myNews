package com.example.my_news.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.my_news.domain.model.Article

@Database(entities = [Article::class], version = 2)
@TypeConverters(value = [NewsTypeConverter::class])
abstract class NewsDatabase : RoomDatabase() {

    abstract val newsDao: NewsDao

}