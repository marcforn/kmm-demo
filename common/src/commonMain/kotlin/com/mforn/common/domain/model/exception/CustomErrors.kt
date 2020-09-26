package com.mforn.common.domain.model.exception

private const val NOT_INITIALIZED = 1000
private const val API_ERROR = 1001
private const val NETWORK_ERROR = 1002
private const val INTERNAL_ERROR = 1003


sealed class CustomErrorType {

    class NotInitializedError() : CustomException("Not Initialized Error: SDK Not Initialized. Please check documentation", NOT_INITIALIZED)

    class ApiError(httpCode: Int, sdkMessage: String?) : CustomException("Api Error: HttpStatus: $httpCode - Message:$sdkMessage", API_ERROR)

    class NetworkError(sdkMessage: String = "") : CustomException("Network error: $sdkMessage", NETWORK_ERROR)

    class InternalError(sdkMessage: String = "") : CustomException("Internal error: $sdkMessage", INTERNAL_ERROR)
}

open class CustomException(message: String, val code: Int) : Exception(message)