package com.godjoy.spacesounds.domain.model

import com.google.gson.annotations.SerializedName

data class NasaItems(
    @field:SerializedName("href") val href: String,
    @field:SerializedName("data") val data: List<NasaData>,
    @field:SerializedName("links") val links: List<NasaLink>?,
)
