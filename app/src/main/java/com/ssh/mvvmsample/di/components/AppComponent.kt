package com.ssh.mvvmsample.di.components

import android.app.Application
import com.ssh.mvvmsample.MvvmApplication
import com.ssh.mvvmsample.data.api.NetworkModule
import com.ssh.mvvmsample.data.repositories.RepositoryModule
import com.ssh.mvvmsample.di.modules.ActivityModule
import com.ssh.mvvmsample.di.modules.AppModule
import com.ssh.mvvmsample.di.modules.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        NetworkModule::class,
        RepositoryModule::class,
        ActivityModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent : AndroidInjector<MvvmApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    override fun inject(instance: MvvmApplication?)
}