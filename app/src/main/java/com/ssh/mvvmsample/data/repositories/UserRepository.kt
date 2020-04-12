package com.ssh.mvvmsample.data.repositories

import com.ssh.mvvmsample.data.User
import com.ssh.mvvmsample.data.api.GithubApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

interface UserRepository {

    fun getUser(
        username: String,
        onSuccess: (user: User) -> Unit,
        onFailure: (t: Throwable) -> Unit
    )
}

class UserRepositoryImpl(private val githubApi: GithubApi) : UserRepository {

    override fun getUser(
        username: String,
        onSuccess: (user: User) -> Unit,
        onFailure: (t: Throwable) -> Unit
    ) {
        githubApi.getUser(username).enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                response.body()?.let { user ->
                    onSuccess.invoke(user)
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                onFailure.invoke(t)
            }
        })
    }
}