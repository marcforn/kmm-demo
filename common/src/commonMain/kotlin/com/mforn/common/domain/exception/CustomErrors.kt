package com.mforn.common.domain.exception

private const val API_ERROR = 1001
private const val NETWORK_ERROR = 1002
private const val INTERNAL_ERROR = 1003


sealed class CustomErrorType {

    class ApiError(httpCode: Int, sdkMessage: String?) : CustomException("Api Error: HttpStatus: $httpCode - Message:$sdkMessage", API_ERROR)

    class NetworkError(sdkMessage: String = "") : CustomException("Network error: $sdkMessage", NETWORK_ERROR)

    class InternalError(sdkMessage: String = "") : CustomException("Internal error: $sdkMessage", INTERNAL_ERROR)
}

open class CustomException(message: String, val code: Int) : Exception(message)