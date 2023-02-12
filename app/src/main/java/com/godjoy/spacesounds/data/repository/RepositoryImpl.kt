package com.godjoy.spacesounds.data.repository

import com.godjoy.spacesounds.data.nasa.NasaApiService
import com.godjoy.spacesounds.domain.model.NasaPhoto
import com.godjoy.spacesounds.domain.repository.Repository
import com.godjoy.spacesounds.utils.Response
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.lang.Exception
import javax.inject.Inject

class RepositoryImpl @Inject constructor(val nasaApiService: NasaApiService) : Repository {
    override suspend fun getImages(query: String, page: Int): Flow<Response<List<NasaPhoto>>> = flow {
        try {
            emit(Response.Loading)
            val photos = nasaApiService.getImages(query, page).collection.items.map {
                with(it) {
                    NasaPhoto(
                        nasaId = data[0].id,
                        imgSrc = links?.get(0)?.href,
                        title = data[0].title,
                        description = data[0].description,
                        date = data[0].date
                    )
                }
            }.toList()
            emit(Response.Success(photos))
        } catch (e: Exception) {
            emit(Response.Failure(e))
        }
    }.flowOn(Dispatchers.IO)

    override suspend fun getImageDetail(nasaId: String): Flow<Response<NasaPhoto>> = flow {
        try {
            emit(Response.Loading)
            val detail = with(nasaApiService.getDetailById(nasaId).collection.items[0]) {
                NasaPhoto(
                    nasaId = nasaId,
                    imgSrc = links?.get(0)?.href,
                    title = data[0].title,
                    description = data[0].description,
                    date = data[0].date
                )
            }
            emit(Response.Success(detail))
        } catch (e: Exception) {
            emit(Response.Failure(e))
        }
    }.flowOn(Dispatchers.IO)

}