package io.gghf.core.client

sealed class ServiceResult<Success, Failure> {
    data class Success<Success, Failure>(val success: Success) : ServiceResult<Success, Failure>()
    data class Failure<Success, Failure>(val failure: Failure) : ServiceResult<Success, Failure>()
}
