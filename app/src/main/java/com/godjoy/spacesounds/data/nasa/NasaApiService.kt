package com.godjoy.spacesounds.data.nasa

import com.godjoy.spacesounds.domain.model.NasaResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NasaApiService {
    @GET("search?media_type=image")
    suspend fun getImages(
        @Query("q") query: String,
        @Query("page") page: Int
    ): NasaResponse

    @GET("search")
    suspend fun getDetailById(
        @Query("nasa_id") nasaId: String
    ): NasaResponse

    @GET("search?q=Sound&media_type=audio")
    suspend fun getSounds(
        @Query("page") page: Int
    ): NasaResponse
}