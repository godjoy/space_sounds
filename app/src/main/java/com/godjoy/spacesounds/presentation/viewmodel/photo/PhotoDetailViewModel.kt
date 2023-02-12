package com.godjoy.spacesounds.presentation.viewmodel.photo

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.godjoy.spacesounds.domain.model.NasaPhoto
import com.godjoy.spacesounds.domain.repository.Repository
import com.godjoy.spacesounds.utils.Response
import com.godjoy.spacesounds.utils.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhotoDetailViewModel @Inject constructor(
    private val repository: Repository
): ViewModel() {
    var photoDetailUiState: UiState<NasaPhoto> by mutableStateOf(UiState.Loading)
        private set

    fun getPhotoDetail(nasaId: String) {
        viewModelScope.launch {
            repository.getImageDetail(nasaId).collectLatest {
                photoDetailUiState = when (it) {
                    is Response.Failure -> UiState.Error
                    Response.Loading -> UiState.Loading
                    is Response.Success -> if (it.data != null) UiState.Success(it.data) else UiState.Error
                }
            }
        }
    }
}