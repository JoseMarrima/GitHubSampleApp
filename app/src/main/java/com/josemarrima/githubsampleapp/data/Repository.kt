package com.josemarrima.githubsampleapp.data

import com.josemarrima.githubsampleapp.data.local.RepoDao
import com.josemarrima.githubsampleapp.data.remote.RepoService
import com.josemarrima.githubsampleapp.util.ResponseHandler
import javax.inject.Singleton

@Singleton
class Repository(val repoDao: RepoDao,
                 val repoService: RepoService,
                 val responseHandler: ResponseHandler) {

}