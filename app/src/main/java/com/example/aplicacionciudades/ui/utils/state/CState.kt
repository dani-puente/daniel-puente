package com.example.aplicacionciudades.ui.utils.state

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract
import com.example.aplicacionciudades.ui.utils.state.StateExt.hasData as extHasData
import com.example.aplicacionciudades.ui.utils.state.StateExt.hasErrors as extHasErro
sealed class State {
    object Idle : State(), IIdle
    object Loading : State(), ILoading
    object Success : State(), ISuccess
    object Failure : State(), IFailure

    fun isIdle() = this is Idle
    fun isLoading() = this is Loading
    fun isSuccess() = this is Success
    fun isFailure() = this is Failure
}

sealed class StateT<out T> {
    object Idle : StateT<Nothing>(), IIdle
    object Loading : StateT<Nothing>(), ILoading
    data class Success<T>(override val data: T) : StateT<T>(), ISuccessWithData<T>
    object Failure : StateT<Nothing>(), IFailure

    fun isIdle() = this is Idle
    fun isLoading() = this is Loading
    fun isFailure() = this is Failure

    @OptIn(ExperimentalContracts::class)
    fun isSuccess(): Boolean {
        contract {
            returns(true) implies (this@StateT is Success)
        }
        return this is Success
    }

    @OptIn(ExperimentalContracts::class)
    fun hasData(): Boolean {
        contract {
            returns(true) implies (this@StateT is Success)
        }
        return this is Success && extHasData()
    }
}

sealed class StateE<out E> {
    object Idle : StateE<Nothing>(), IIdle
    object Loading : StateE<Nothing>(), ILoading
    object Success : StateE<Nothing>(), ISuccess
    data class Failure<E>(override val error: E) : StateE<E>(), IFailureWithError<E>

    fun isIdle() = this is Idle
    fun isLoading() = this is Loading
    fun isSuccess() = this is Success

    @OptIn(ExperimentalContracts::class)
    fun isFailure(): Boolean {
        contract {
            returns(true) implies (this@StateE is Failure)
        }
        return this is Failure
    }

    @OptIn(ExperimentalContracts::class)
    fun hasErrors(): Boolean {
        contract {
            returns(true) implies (this@StateE is Failure)
        }
        return this is Failure && extHasErrors()
    }
}

sealed class StateTE<out T, out E> {
    object Idle : StateTE<Nothing, Nothing>(), IIdle
    object Loading : StateTE<Nothing, Nothing>(), ILoading
    data class Success<T>(override val data: T) : StateTE<T, Nothing>(),
        ISuccessWithData<T>

    data class Failure<E>(override val error: E) : StateTE<Nothing, E>(),
        IFailureWithError<E>

    fun isIdle() = this is StateTE.Idle
    fun isLoading() = this is StateTE.Loading

    @OptIn(ExperimentalContracts::class)
    fun isSuccess(): Boolean {
        contract {
            returns(true) implies (this@StateTE is Success)
        }
        return this is Success
    }

    @OptIn(ExperimentalContracts::class)
    fun isFailure(): Boolean {
        contract {
            returns(true) implies (this@StateTE is Failure)
        }
        return this is Failure
    }

    @OptIn(ExperimentalContracts::class)
    fun hasErrors(): Boolean {
        contract {
            returns(true) implies (this@StateTE is Failure)
        }
        return this is Failure && extHasErrors()
    }

    @OptIn(ExperimentalContracts::class)
    fun hasData(): Boolean {
        contract {
            returns(true) implies (this@StateTE is Success)
        }
        return this is Success && extHasData()
    }
}