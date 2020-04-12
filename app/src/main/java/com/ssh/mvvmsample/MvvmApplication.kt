package com.ssh.mvvmsample

import com.ssh.mvvmsample.di.components.AppComponent
import com.ssh.mvvmsample.di.components.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class MvvmApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        //Build app component
        val appComponent: AppComponent = DaggerAppComponent.builder()
            .application(this)
            .build()
        //inject application instance
        appComponent.inject(this)
        return appComponent
    }
}