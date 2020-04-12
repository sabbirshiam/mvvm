package com.ssh.mvvmsample.di.modules

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.ssh.mvvmsample.data.api.GithubApi
import com.ssh.mvvmsample.viewmodels.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
abstract class AppModule {

    @Binds
    abstract fun bindContext(application: Application): Context

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}