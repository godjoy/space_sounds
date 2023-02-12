package com.godjoy.spacesounds.utils

sealed class UiState<out T> {
    data class Success<out T>(
        val data: T
    ): UiState<T>()
    object Error: UiState<Nothing>()
    object Loading: UiState<Nothing>()
}