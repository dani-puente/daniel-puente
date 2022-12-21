package com.example.aplicacionciudades.ui.utils.state.ext

import com.example.aplicacionciudades.ui.utils.state.IFailureWithError
import com.example.aplicacionciudades.ui.utils.state.ISuccessWithData


fun <T> ISuccessWithData<T>.hasData() =
    data != null && !(data is Iterable<*> && ((data as? Iterable<*>)?.count() ?: 0) == 0)
fun <E> IFailureWithError<E>.hasErrors() =
    error != null && !(error is Iterable<*> && ((error as? Iterable<*>)?.count() ?: 0) == 0)
val <E>IFailureWithError<E>.firstErrorOrNull get() = if (error is Iterable<*>) (error as? Iterable<*>)?.firstOrNull() else error