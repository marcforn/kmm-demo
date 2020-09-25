package com.mforn.common.domain.coroutine

import com.mforn.common.domain.exception.CustomErrorType
import com.mforn.common.domain.exception.CustomException


/**
 * Encapsulate any possible Exception into CustomException
 *
 * @param block -> Block of code that will be executed
 * @throws CustomException -> If CustomException is already cached then this exception is populated, otherwise any other Exception is encapsulated into Internal error and propagated.
 */
@Throws(Exception::class)
suspend fun <T> exceptionHandler(block: suspend () -> T): T {
    try {
        return block()
    } catch (exception: Exception) {
        when (exception) {
            is CustomException -> throw exception
            else -> throw CustomErrorType.InternalError(exception.message ?: "Unknown InternalError")
        }
    }
}