package com.godjoy.spacesounds.di

import com.godjoy.spacesounds.utils.Const.BASE_URL
import com.godjoy.spacesounds.data.nasa.NasaApiService
import com.godjoy.spacesounds.data.repository.RepositoryImpl
import com.godjoy.spacesounds.domain.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
class AppModules {

    @Provides
    @Named("NASA_BASE_URL")
    fun provideNasaBaseUrl(): String = BASE_URL

    @Provides
    fun provideRetrofit(@Named("NASA_BASE_URL") baseUrl: String): Retrofit {
        val client = OkHttpClient
            .Builder()
            .addInterceptor(
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            ).build()
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    @Provides
    fun provideNasaApi(retrofit: Retrofit): NasaApiService = retrofit.create(NasaApiService::class.java)

    @Provides
    fun provideRepository(nasaApiService: NasaApiService): Repository = RepositoryImpl(nasaApiService = nasaApiService)

}