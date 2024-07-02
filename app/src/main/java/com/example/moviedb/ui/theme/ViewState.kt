package com.example.moviedb.ui.theme

sealed class ViewState<out T> {
    data object Loading:ViewState<Nothing>()
    data class Success<out T>(val data:T):ViewState<T>()
    data class Error(val message:String):ViewState<Nothing>()

}