package com.fshou.mouvie.ui.utils

sealed interface UiState<out R> {
    object Loading : UiState<Nothing>

    data class Success<out T>(
        val data: T
    ) : UiState<T>

    data class Error(
        val msg: String
    ) : UiState<Nothing>
}