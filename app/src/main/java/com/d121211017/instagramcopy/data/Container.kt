package com.d121211017.instagramcopy.data

import com.d121211017.instagramcopy.data.repository.NetworkRepository
import com.d121211017.instagramcopy.data.repository.Repository
import com.d121211017.instagramcopy.data.source.remote.ApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.create

interface Container{
    val repository: Repository
}

class DefaultAppContainer: Container{
    private val baseUrl= "https://6555c3a784b36e3a431e45f1.mockapi.io/"

    private val retrofit = Retrofit
        .Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()

    private val retrofitService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }

    override val repository: Repository by lazy {
        NetworkRepository(retrofitService)
    }
}