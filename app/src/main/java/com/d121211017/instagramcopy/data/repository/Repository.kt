package com.d121211017.instagramcopy.data.repository

import com.d121211017.instagramcopy.data.model.posts
import com.d121211017.instagramcopy.data.source.remote.ApiService

interface Repository{
    suspend fun getPosts():posts
}

class NetworkRepository(private val apiService: ApiService):Repository{
    override suspend fun getPosts(): posts = apiService.getPosts()
}