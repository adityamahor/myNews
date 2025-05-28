package com.example.my_news.domain.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize


@Parcelize
@Entity
data class Article(
    val author: String?,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: Source,  // object convert into primitive data type because in room db we can't store object
    val title: String,
    @PrimaryKey val url: String,
    val urlToImage: String
): Parcelable