package com.josemarrima.githubsampleapp.data

import androidx.lifecycle.LiveData
import com.josemarrima.githubsampleapp.data.local.RepoDao
import com.josemarrima.githubsampleapp.data.remote.RepoService
import com.josemarrima.githubsampleapp.domain.GitHubResponse
import com.josemarrima.githubsampleapp.domain.Repo
import com.josemarrima.githubsampleapp.domain.asDomainModel
import com.josemarrima.githubsampleapp.util.Resource
import com.josemarrima.githubsampleapp.util.ResponseHandler
import timber.log.Timber
import java.lang.Exception
import javax.inject.Singleton

@Singleton
class Repository(private val repoDao: RepoDao,
                 private val repoService: RepoService,
                 private val responseHandler: ResponseHandler) {

    suspend fun cacheData() {
        val repoResponse: Resource<GitHubResponse>
        Timber.d("cache data is called")
        repoResponse = try {
            val repo = repoService.getAsyncListRepo("Android")
            Timber.d("Response from network ${repo.total_count}")
            responseHandler.handleSuccess(repo)
        } catch (e: Exception) {
            Timber.d("Response from network ${e.message}")
            responseHandler.handleException(e)
        }

        Timber.d("Status is ${repoResponse.status}")
        Timber.d("Error is ${repoResponse.message}")
        if (repoResponse.status == Resource.Status.SUCCESS) {
            repoDao.insertListRepo(repoResponse.data!!.asDomainModel())
        }
    }

    fun getListRepo(): LiveData<List<Repo>> {
        return repoDao.getListRepo()
    }

}