package com.godjoy.spacesounds.presentation.ui.photo.search

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.godjoy.spacesounds.presentation.ui.component.PhotoCards
import com.godjoy.spacesounds.presentation.viewmodel.photo.PhotoViewModel
import com.godjoy.spacesounds.utils.UiState

@Composable
fun PhotoSearchFragment(
    modifier: Modifier = Modifier,
    photoSearchViewModel: PhotoViewModel = hiltViewModel(),
    goDetailScreen: (String) -> Unit = {}
) {
    Surface(
        modifier = modifier.fillMaxSize()
            .padding(30.dp),
        color = MaterialTheme.colors.background
    ) {

        when (val uiState = photoSearchViewModel.photoSearchUiState) {
            UiState.Error -> println("error screen")
            UiState.Loading -> println("Loading screen")
            is UiState.Success -> PhotoCards(
                modifier = modifier,
                selectPhoto = goDetailScreen,
                photos = uiState.data
            )
        }
    }
}