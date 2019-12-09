package com.josemarrima.githubsampleapp.domain

fun GitHubResponse.asDomainModel(): List<Repo> {
    return items.map {
        Repo(id = it.id,
            nameRepo = it.name,
            description = it.description,
            language = it.language,
            stargazersCount = it.stargazers_count)
    }
}