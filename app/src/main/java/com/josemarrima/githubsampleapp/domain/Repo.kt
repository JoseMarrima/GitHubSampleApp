package com.josemarrima.githubsampleapp.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Repo(val id: Long,
                val nameRepo: String,
                val description: String,
                val language: String,
                val stargazersCount: Long): Parcelable