package com.ssh.mvvmsample.view

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ssh.mvvmsample.R
import com.ssh.mvvmsample.data.api.GithubApi
import com.ssh.mvvmsample.databinding.ActivityMainBinding
import com.ssh.mvvmsample.viewmodels.MainViewModel
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    @Inject
    lateinit var githubApi: GithubApi

    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        //provide view model
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        //assign viewModel to data binding layout variable
        binding.viewModel = viewModel

        viewModel.fullName.observe(this, Observer { name ->
            fullName.text = name
        })
    }

    override fun onStart() {
        super.onStart()
        search.setOnClickListener {
            viewModel.searchUser(username.text.toString())
        }
    }
}
