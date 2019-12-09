package com.josemarrima.githubsampleapp.data.remote

import com.josemarrima.githubsampleapp.domain.GitHubResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RepoService {
    @GET("search/repositories?sort=stars")
    suspend fun getAsyncListRepo(@Query("q") query: String): GitHubResponse
}