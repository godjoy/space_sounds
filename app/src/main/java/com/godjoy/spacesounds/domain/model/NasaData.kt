package com.godjoy.spacesounds.domain.model

import com.google.gson.annotations.SerializedName

data class NasaData(
    @field:SerializedName("title") val title: String,
    @field:SerializedName("nasa_id") val id: String,
    @field:SerializedName("date_created") val date: String,
    @field:SerializedName("description") val description: String,
)