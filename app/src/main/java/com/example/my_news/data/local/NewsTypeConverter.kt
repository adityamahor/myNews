package com.example.my_news.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.my_news.domain.model.Source

@ProvidedTypeConverter
class NewsTypeConverter {


    @TypeConverter
    fun sourceToString(source: Source) : String{
        return "${source.name},${source.name}"
    }

    @TypeConverter
    fun stringToSource(string: String) : Source{
        val source = string.split(",").let {
            Source(id = it[0], name = it[1])
        }
        return source
    }


}