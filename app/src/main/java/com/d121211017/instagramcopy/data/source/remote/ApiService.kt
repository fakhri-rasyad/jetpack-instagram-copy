package com.d121211017.instagramcopy.data.source.remote

import com.d121211017.instagramcopy.data.model.posts
import retrofit2.http.GET

interface ApiService {
    @GET("posts")
    suspend fun getPosts(): posts
}