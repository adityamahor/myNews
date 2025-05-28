package com.example.my_news.data.di

import android.app.Application
import androidx.room.Room
import com.example.my_news.data.local.NewsDao
import com.example.my_news.data.local.NewsDatabase
import com.example.my_news.data.local.NewsTypeConverter
import com.example.my_news.data.manager.localUsermanagerImple
import com.example.my_news.data.remote.NewsApi
import com.example.my_news.data.repository.NewsRepositoryImple
import com.example.my_news.domain.manager.localUsermanager
import com.example.my_news.domain.repository.NewsRepository
import com.example.my_news.domain.usecase.app_entry.AllAppEntryUseCase
import com.example.my_news.domain.usecase.app_entry.getAppEntryUseCase
import com.example.my_news.domain.usecase.app_entry.saveAppEntryUseCase
import com.example.my_news.domain.usecase.news.DeleteNewsUseCase
import com.example.my_news.domain.usecase.news.GetNewsUseCase
import com.example.my_news.domain.usecase.news.InsertNewsUseCase
import com.example.my_news.domain.usecase.news.NewsUseCase
import com.example.my_news.domain.usecase.news.SelectInsertDeleteUseCase
import com.example.my_news.domain.usecase.news.SelectNewsUseCase
import com.example.my_news.domain.usecase.news.searchNewsUseCase
import com.example.my_news.utils.contants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideLocalUserManager(application: Application):localUsermanager{
        return localUsermanagerImple(application)
    }

    @Provides
    @Singleton
    fun provideAppEntryUseCase(localUsermanager: localUsermanager): AllAppEntryUseCase{
        return AllAppEntryUseCase(
            readEntry = getAppEntryUseCase(localUsermanager),
            saveEntry = saveAppEntryUseCase(localUsermanager)
        )
    }

    @Provides
    @Singleton
    fun provideNewsApi(): NewsApi{
        return Retrofit.Builder()
            .baseUrl(contants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(newsApi: NewsApi,newsDao: NewsDao): NewsRepository {
        return NewsRepositoryImple(newsApi,newsDao)
    }

    @Provides
    @Singleton
    fun provideNewsUseCase(newsRepository: NewsRepository): NewsUseCase {
        return NewsUseCase(
            getNewsUseCase = GetNewsUseCase(newsRepository),
            searchNewsUseCase = searchNewsUseCase(newsRepository),
            insertNewsUseCase = InsertNewsUseCase(newsRepository),
            deleteNewsUseCase = DeleteNewsUseCase(newsRepository),
            selectNewsUseCase = SelectNewsUseCase(newsRepository),
            selectInsertDeleteUseCase = SelectInsertDeleteUseCase(newsRepository)
        )
    }

    @Provides
    @Singleton
    fun provideNewsDatabase(application: Application): NewsDatabase{
        return Room.databaseBuilder(
            application,
            NewsDatabase::class.java,
            contants.DATABASE_NAME
        ).addTypeConverter(NewsTypeConverter())
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideNewsDao(newsDatabase: NewsDatabase) : NewsDao = newsDatabase.newsDao


}