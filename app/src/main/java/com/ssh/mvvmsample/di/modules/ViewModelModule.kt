package com.ssh.mvvmsample.di.modules

import androidx.lifecycle.ViewModel
import com.ssh.mvvmsample.di.ViewModelKey
import com.ssh.mvvmsample.viewmodels.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel) : ViewModel
}