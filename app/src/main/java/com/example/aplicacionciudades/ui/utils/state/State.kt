package com.example.aplicacionciudades.ui.utils.state


import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract
sealed class State : IState {
    object Idle : State(), IIdle
    object Loading : State(), ILoading
    object Success : State(), ISuccess
    object Failure : State(), IFailure
}
sealed class StateT<out T> : IStateT<T> {
    object Idle : StateT<Nothing>(), IIdle
    object Loading : StateT<Nothing>(), ILoading
    data class Success<T>(override val data: T) : StateT<T>(), ISuccessWithData<T>
    object Failure : StateT<Nothing>(), IFailure
    @OptIn(ExperimentalContracts::class)
    fun isSuccessX(): Boolean {
        contract {
            returns(true) implies (this@StateT is Success)
        }
        return this is Success
    }
    @OptIn(ExperimentalContracts::class)
    fun hasDataX(): Boolean {
        contract {
            returns(true) implies (this@StateT is Success)
        }
        return this is Success && hasData()
    }
}
sealed class StateE<out E> : IStateE<E> {
    object Idle : StateE<Nothing>(), IIdle
    object Loading : StateE<Nothing>(), ILoading
    object Success : StateE<Nothing>(), ISuccess
    data class Failure<E>(override val error: E) : StateE<E>(), IFailureWithError<E>
    @OptIn(ExperimentalContracts::class)
    fun isFailureX(): Boolean {
        contract {
            returns(true) implies (this@StateE is Failure)
        }
        return this is Failure
    }
    @OptIn(ExperimentalContracts::class)
    fun hasErrorsX(): Boolean {
        contract {
            returns(true) implies (this@StateE is Failure)
        }
        return this is Failure && hasErrors()
    }
}
sealed class StateTE<out T, out E> : IStateTE<T, E> {
    object Idle : StateTE<Nothing, Nothing>(), IIdle
    object Loading : StateTE<Nothing, Nothing>(), ILoading
    data class Success<T>(override val data: T) : StateTE<T, Nothing>(),
        ISuccessWithData<T>
    data class Failure<E>(override val error: E) : StateTE<Nothing, E>(),
        IFailureWithError<E>
    @OptIn(ExperimentalContracts::class)
    fun isSuccessX(): Boolean {
        contract {
            returns(true) implies (this@StateTE is Success)
        }
        return this is Success
    }
    @OptIn(ExperimentalContracts::class)
    fun hasDataX(): Boolean {
        contract {
            returns(true) implies (this@StateTE is Success)
        }
        return this is Success && hasData()
    }
    @OptIn(ExperimentalContracts::class)
    fun isFailureX(): Boolean {
        contract {
            returns(true) implies (this@StateTE is Failure)
        }
        return this is Failure
    }
    @OptIn(ExperimentalContracts::class)
    fun hasErrorsX(): Boolean {
        contract {
            returns(true) implies (this@StateTE is Failure)
        }
        return this is Failure && hasErrors()
    }
}