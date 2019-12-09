package com.josemarrima.githubsampleapp.di.listRepo

import androidx.lifecycle.ViewModel
import com.josemarrima.githubsampleapp.di.ViewModelKey
import com.josemarrima.githubsampleapp.listRepo.ListRepoViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ListRepoViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ListRepoViewModel::class)
    abstract fun bindListRepoViewModel(listRepoViewModel: ListRepoViewModel): ViewModel
}