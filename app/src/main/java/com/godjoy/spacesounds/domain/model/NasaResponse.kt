package com.godjoy.spacesounds.domain.model

import com.google.gson.annotations.SerializedName

data class NasaResponse(
    @field:SerializedName("collection") val collection: NasaCollection
)

data class NasaCollection(
    @field:SerializedName("items") val items: List<NasaItems>
)