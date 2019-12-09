package com.josemarrima.githubsampleapp.di

import android.content.Context
import androidx.room.Room
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.josemarrima.githubsampleapp.data.Repository
import com.josemarrima.githubsampleapp.data.local.RepoDao
import com.josemarrima.githubsampleapp.data.local.RepoDatabase
import com.josemarrima.githubsampleapp.data.remote.RepoService
import com.josemarrima.githubsampleapp.util.DATABASE_NAME
import com.josemarrima.githubsampleapp.util.ResponseHandler
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
object AppModule {
    @JvmStatic
    @Singleton
    @Provides
    fun provideResponseHandler(): ResponseHandler {
        return ResponseHandler()
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideRepoService(): RepoService {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .baseUrl("https://api.github.com/")
            .build()
            .create(RepoService::class.java)
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideRepoDao(repoDatabase: RepoDatabase): RepoDao {
        return repoDatabase.repoDao()
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideRepoDatabase(context: Context): RepoDatabase {
        return Room.databaseBuilder(context,
            RepoDatabase::class.java, DATABASE_NAME).build()
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideRepository(repoDao: RepoDao,
                               repoService: RepoService,
                               responseHandler: ResponseHandler): Repository {

        return Repository(repoDao, repoService, responseHandler)
    }
}