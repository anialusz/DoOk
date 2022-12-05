package com.example.dook

import retrofit2.Response
import retrofit2.http.GET

interface NasaService {

    @GET("apod?api_key=gEE4HeYL9m6N1W2O65MLZV3zduuXaurNrDmTy2EI&count=3")
    suspend fun getAstronomicPictures(): Response<List<AstronomicPictures>>
}