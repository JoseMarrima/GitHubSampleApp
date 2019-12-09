package com.josemarrima.githubsampleapp.di

import com.josemarrima.githubsampleapp.di.listRepo.ListRepoViewModelModule
import com.josemarrima.githubsampleapp.di.repoDetails.RepoDetailsViewModelModule
import com.josemarrima.githubsampleapp.listRepo.ListRepoFragment
import com.josemarrima.githubsampleapp.repoDetails.RepoDetailsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilderModule {
    @ContributesAndroidInjector(modules = [ListRepoViewModelModule::class])
    abstract fun contributeListRepoFragment(): ListRepoFragment

    @ContributesAndroidInjector(modules = [RepoDetailsViewModelModule::class])
    abstract fun contributeRepoDetailsRepoFragment(): RepoDetailsFragment
}