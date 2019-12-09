package com.josemarrima.githubsampleapp.listRepo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.josemarrima.githubsampleapp.data.Repository
import kotlinx.coroutines.launch
import javax.inject.Inject

class ListRepoViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    val repos = repository.getListRepo()

    init {
        cacheData()
    }

    private fun cacheData() {
        viewModelScope.launch {
            repository.cacheData()
        }
    }
}
