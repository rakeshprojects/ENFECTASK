package com.example.taskenfc.service
import com.example.taskenfc.model.Post
import com.example.taskenfc.model.User
import retrofit2.http.GET
import retrofit2.Call

interface ApiService {
    @GET("posts")
    fun getPosts(): Call<List<Post>>

    @GET("users")
    fun getUsers(): Call<List<User>>
}