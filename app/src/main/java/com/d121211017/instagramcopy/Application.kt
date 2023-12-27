package com.d121211017.instagramcopy

import android.app.Application
import com.d121211017.instagramcopy.data.Container
import com.d121211017.instagramcopy.data.DefaultAppContainer

class InstagramApplication(): Application() {
    lateinit var container: Container

    override fun onCreate(){
        super.onCreate()
        container = DefaultAppContainer()
    }
}