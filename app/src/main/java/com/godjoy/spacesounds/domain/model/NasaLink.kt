package com.godjoy.spacesounds.domain.model

import com.google.gson.annotations.SerializedName

data class NasaLink(
    @field:SerializedName("href") val href: String,
    @field:SerializedName("render") val render: String
)