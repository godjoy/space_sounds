package com.godjoy.spacesounds.presentation.ui.photo.detail

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.godjoy.spacesounds.presentation.ui.photo.detail.component.PhotoDetail
import com.godjoy.spacesounds.presentation.viewmodel.photo.PhotoDetailViewModel
import com.godjoy.spacesounds.utils.UiState

@Composable
fun PhotoDetailFragment(
    modifier: Modifier = Modifier,
    detailViewModel: PhotoDetailViewModel = hiltViewModel(),
    nasaId: String
) {
    fun launch() {
        detailViewModel.getPhotoDetail(nasaId)
    }
    launch()
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        when (val uiState = detailViewModel.photoDetailUiState) {
            UiState.Error -> println("error screen")
            UiState.Loading -> println("Loading screen")
            is UiState.Success -> PhotoDetail(modifier = modifier, photo = uiState.data)
        }
    }
}