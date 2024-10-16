package com.example.taskenfc.model

import com.google.gson.JsonObject

data class Post(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)
data class User(
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    val address : Address
)

data class Address(
    val geo: JsonObject,
)

data class PostUser(
    val post: Post,
    val user: User
)
