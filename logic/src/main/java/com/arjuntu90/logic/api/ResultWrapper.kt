package com.arjuntu90.logic.api

sealed class ResultWrapper<out R> {
    data class Success<out T>(val data: T) : ResultWrapper<T>()
    data class Error(val e: Exception) : ResultWrapper<Nothing>()
    object Loading : ResultWrapper<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success = $data"
            is Error -> "Error = $e"
            Loading -> "Loading"
        }
    }
}

val ResultWrapper<*>.succeeded
    get() = this is ResultWrapper.Success && data != null