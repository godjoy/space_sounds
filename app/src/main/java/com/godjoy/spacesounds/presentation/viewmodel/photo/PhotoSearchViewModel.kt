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
class PhotoViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    var photoSearchUiState: UiState<List<NasaPhoto>> by mutableStateOf(UiState.Loading)
        private set

    init {
        getImages()
    }

    private fun getImages() {
        viewModelScope.launch {
            repository.getImages("Galaxy", 1).collectLatest {
                photoSearchUiState = when (it) {
                    is Response.Failure -> UiState.Error
                    Response.Loading -> UiState.Loading
                    is Response.Success -> {
                        println("PhotoViewModel: ${it.data}")
                        UiState.Success(it.data ?: emptyList())
                    }
                }
            }
        }
    }
}