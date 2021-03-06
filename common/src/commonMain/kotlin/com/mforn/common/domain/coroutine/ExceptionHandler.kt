package com.mforn.common.domain.coroutine

import com.mforn.common.domain.model.exception.CustomErrorType
import com.mforn.common.domain.model.exception.CustomException
import kotlin.coroutines.cancellation.CancellationException


/**
 * Encapsulate any possible Exception into CustomException
 *
 * @param block -> Block of code that will be executed
 * @throws CustomException -> If CustomException is already cached then this exception is populated, otherwise any other Exception is encapsulated into Internal error and propagated.
 * @throws CancellationException -> Suspend block has been canceled
 */
@ExperimentalStdlibApi
@Throws(CustomException::class, CancellationException::class)
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