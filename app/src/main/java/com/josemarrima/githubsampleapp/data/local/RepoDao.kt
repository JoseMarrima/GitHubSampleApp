package com.josemarrima.githubsampleapp.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.josemarrima.githubsampleapp.domain.Repo

@Dao
interface RepoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertListRepo(listRepo: List<Repo>)

    @Query("SELECT * from repo")
    fun getListRepo(): LiveData<List<Repo>>
}