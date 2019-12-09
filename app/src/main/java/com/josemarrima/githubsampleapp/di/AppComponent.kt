package com.josemarrima.githubsampleapp.di

import android.content.Context
import com.josemarrima.githubsampleapp.MainApplication
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class,
    ViewModelFactoryModule::class,
    FragmentBuilderModule::class,
    AndroidSupportInjectionModule::class])
interface AppComponent: AndroidInjector<MainApplication> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): AppComponent
    }
}