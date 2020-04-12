package com.ssh.mvvmsample.data.repositories

import com.ssh.mvvmsample.data.api.GithubApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun providesUserRepository(githubApi: GithubApi): UserRepository {
        return UserRepositoryImpl(githubApi)
    }
}