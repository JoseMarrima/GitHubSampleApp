package com.josemarrima.githubsampleapp.domain

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class Repo(@PrimaryKey val id: Long,
                val nameRepo: String,
                val description: String,
                val language: String,
                val stargazersCount: Long): Parcelable