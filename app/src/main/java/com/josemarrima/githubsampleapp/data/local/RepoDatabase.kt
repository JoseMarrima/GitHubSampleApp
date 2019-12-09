package com.josemarrima.githubsampleapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.josemarrima.githubsampleapp.domain.Repo

@Database(entities = [Repo::class], version = 1, exportSchema = false)
abstract class RepoDatabase: RoomDatabase() {
    abstract fun repoDao(): RepoDao
}