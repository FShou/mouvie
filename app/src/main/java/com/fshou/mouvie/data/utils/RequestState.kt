package com.fshou.mouvie.data.utils

sealed class RequestState<out R> private constructor(){
    data object Loading: RequestState<Nothing>()
    data class Success<out T>(val data: T) : RequestState<T>()
    data class Error(val msg: String) : RequestState<Nothing>()
}