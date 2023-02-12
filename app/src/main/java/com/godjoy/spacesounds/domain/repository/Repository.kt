package com.godjoy.spacesounds.domain.repository

import com.godjoy.spacesounds.domain.model.NasaPhoto
import com.godjoy.spacesounds.utils.Response
import kotlinx.coroutines.flow.Flow


interface Repository {
    suspend fun getImages(query: String, page: Int): Flow<Response<List<NasaPhoto>>>
    suspend fun getImageDetail(nasaId: String): Flow<Response<NasaPhoto>>
}