package com.example.aplicacionciudades.ui.utils

import com.example.aplicacionciudades.model.consultaapimain.FichaX
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

fun foo(state: State<List<FichaX>, Int>){
    when (state) {
        is State.Failure -> state.errors
        State.Idle -> state
        State.Loading -> state
        is State.Success -> state.data
    }
    if (state.hasErrors()){
        state.errors
    }
}


@OptIn(ExperimentalContracts::class)
sealed class State<out DATA, out ERROR> {
    object Idle : State<Nothing, Nothing>()
    //singleton loading, hereda de State con tipos genericos, son Nothing
    object Loading : State<Nothing, Nothing>()
    // clase de datos hereda de State,  tiene un tipo generico para los datos, que pide en el constructor
    // y un tipo generico nothing para errores pq no tiene
    data class Success<DATA>(val data: DATA) : State<DATA, Nothing>()
    data class Failure<ERROR>(val errors: List<ERROR>) : State<Nothing, ERROR>()
    fun isIdle(): Boolean {
        contract {
            returns(true) implies (this@State is Idle)
        }
        return this is Idle
    }
    fun isLoading(): Boolean {
        contract {
            returns(true) implies (this@State is Loading)
        }
        return this is Loading
    }
    fun isSuccess(): Boolean {
        contract {
            returns(true) implies (this@State is Success)
        }
        return this is Success
    }
    fun isFailure(): Boolean {
        contract {
            returns(true) implies (this@State is Failure)
        }
        return this is Failure
    }
    fun hasErrors(): Boolean {
        contract {
            returns(true) implies (this@State is Failure)
        }
        return this is Failure && errors.isNotEmpty()
    }
}