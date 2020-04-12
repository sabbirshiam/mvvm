package com.ssh.mvvmsample.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ssh.mvvmsample.data.repositories.UserRepository
import javax.inject.Inject

class MainViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {

    private val _fullName = MutableLiveData<String>()
    val fullName: LiveData<String>
        get() = _fullName

    fun searchUser(username: String) {
        userRepository.getUser(username,
            { user -> _fullName.value = user.name },
            { t -> Log.e("MainActivity", "onFailure: ", t) })
    }
}
