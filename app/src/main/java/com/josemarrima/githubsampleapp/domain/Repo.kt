package com.josemarrima.githubsampleapp.domain

data class Repo(val id: Long,
                val nameRepo: String,
                val description: String,
                val language: String,
                val stargazersCount: Long)