package com.josemarrima.githubsampleapp.di.repoDetails

import androidx.lifecycle.ViewModel
import com.josemarrima.githubsampleapp.di.ViewModelKey
import com.josemarrima.githubsampleapp.repoDetails.RepoDetailsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class RepoDetailsViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(RepoDetailsViewModel::class)
    abstract fun bindRepoDetailsViewModel(repoDetailsViewModel: RepoDetailsViewModel): ViewModel
}