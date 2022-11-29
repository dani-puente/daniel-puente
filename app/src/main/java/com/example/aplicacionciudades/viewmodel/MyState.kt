package com.example.aplicacionciudades.viewmodel

enum class MyState {
    Idle, Loading, Success, Failure;

    fun isLoading() = this == Loading
}
