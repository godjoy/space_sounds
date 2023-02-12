package com.godjoy.spacesounds.domain.model

data class NasaPhoto(
    val nasaId: String,
    val imgSrc: String?,
    val title: String,
    val description: String,
    val date: String
)