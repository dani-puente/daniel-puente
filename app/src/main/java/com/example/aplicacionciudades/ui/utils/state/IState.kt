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