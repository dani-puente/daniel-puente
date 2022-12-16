package com.example.aplicacionciudades.ui.utils.state

interface IIdle
interface ILoading
interface ISuccess
interface IFailure
interface ISuccessWithData<out T> : ISuccess {
    val data: T
}
interface IFailureWithError<out E> : IFailure {
    val error: E
}
interface IState {
    fun isIdle() = this is IIdle
    fun isLoading() = this is ILoading
    fun isSuccess() = this is ISuccess
    fun isFailure() = this is IFailure
}
interface IStateT<out T> : IState {
    fun isSuccessWithData() = this is ISuccessWithData<*>
    fun hasData() = if (this is ISuccessWithData<*>) {
        data != null && !(data is Iterable<*> && ((data as? Iterable<*>)?.count() ?: 0) == 0)
    } else false
}
interface IStateE<out E> : IState {
    fun isFailureWithError() = this is IFailureWithError<*>
    fun hasErrors() = if (this is IFailureWithError<*>) {
        error != null && !(error is Iterable<*> && ((error as? Iterable<*>)?.count() ?: 0) == 0)
    } else false
    fun firstErrorOrNull() = if (this is IFailureWithError<*>) {
        @Suppress("UNCHECKED_CAST")
        (if (error is Iterable<*>) (error as? Iterable<*>)?.firstOrNull() else error) as E?
    } else null
}
interface IStateTE<out T, out E> : IStateT<T>, IStateE<E>