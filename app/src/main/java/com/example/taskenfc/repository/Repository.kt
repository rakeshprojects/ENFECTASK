package com.example.taskenfc.repository

import com.example.taskenfc.model.Post
import com.example.taskenfc.model.PostUser
import com.example.taskenfc.model.User
import com.example.taskenfc.service.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class Repository {

    suspend fun getPosts(): List<Post>? {
        return withContext(Dispatchers.IO) {
            try {
                val response = RetrofitInstance.api.getPosts().execute()
                response.body()
            } catch (e: Exception) {
                null
            }
        }
    }

    suspend fun getUsers(): List<User>? {
        return withContext(Dispatchers.IO) {
            try {
                val response = RetrofitInstance.api.getUsers().execute()
                response.body()
            } catch (e: Exception) {
                null
            }
        }
    }

    suspend fun getPostUserData(): List<PostUser>? {
        val posts = getPosts()
        val users = getUsers()

        return if (posts != null && users != null) {
            posts.mapNotNull { post ->
                val user = users.find { it.id == post.id }
                if (user != null) {
                    PostUser(post, user)
                } else {
                    null
                }
            }
        } else {
            null
        }
    }
}