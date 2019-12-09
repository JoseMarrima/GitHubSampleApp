package com.josemarrima.githubsampleapp.data

import com.josemarrima.githubsampleapp.data.local.RepoDao
import javax.inject.Singleton

@Singleton
class Repository(val repoDao: RepoDao) {

}