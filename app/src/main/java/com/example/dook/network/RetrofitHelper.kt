package com.example.dook.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

//    val baseUrl =
//        "https://api.nasa.gov/planetary/apod?api_key=gEE4HeYL9m6N1W2O65MLZV3zduuXaurNrDmTy2EI&count=3"

    val baseUrl =
        "https://api.nasa.gov/planetary/"

    fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}