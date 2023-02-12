package com.godjoy.spacesounds.presentation.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.godjoy.spacesounds.domain.model.NasaPhoto
import com.godjoy.spacesounds.domain.model.nasaPhotos

@Composable
fun PhotoCards(
    modifier: Modifier = Modifier,
    selectPhoto: (String) -> Unit,
    photos: List<NasaPhoto>
) {
    LazyVerticalGrid(
        modifier = modifier.fillMaxSize(),
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(items = photos, key = { photo -> photo.nasaId.hashCode() }) { photo ->
            PhotoCard(
                modifier,
                photo,
                selectPhoto = {
                    photo.nasaId.let { selectPhoto.invoke(it) }
                })
        }
    }
}

@Preview
@Composable
fun PhotoCardsPreview() {
    PhotoCards(selectPhoto = {}, photos = nasaPhotos)
}