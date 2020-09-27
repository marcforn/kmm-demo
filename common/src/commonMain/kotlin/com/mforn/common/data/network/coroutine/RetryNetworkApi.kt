package com.mforn.common.data.network.coroutine

import com.mforn.common.domain.model.exception.CustomErrorType
import com.mforn.common.domain.model.exception.CustomException
import io.ktor.client.features.*
import io.ktor.utils.io.errors.*
import kotlin.coroutines.cancellation.CancellationException

private const val API_RETRIES = 3


/**
 * Retry coroutine in case of error.
 * First we launch block, if this causes an exception that is not IOException we retry it.
 * In case of IOException we immediately throw the exception to interrupt flow.
 * After all retries have been done and no IOException has been launched, we try the block for last attempt. In case of success we just populate the response,
 * otherwise we will throw the proper exception.
 *
 * @param block -> Block of code that will be executed
 * @throws CustomException -> If a connectivity exception is captured (IOException) we do not retry and populate a CustomErrorType.NetworkError()
 * Otherwise we will retry API_RETRIES with API_RETRY_DELAY.
 * @throws CancellationException -> Suspend block has been canceled
 */
@ExperimentalStdlibApi
@Throws(CustomException::class, CancellationException::class)
suspend fun <T> retryApi(block: suspend () -> T): T {
    repeat(API_RETRIES) {
        try {
            return block()
        } catch (exception: Exception) {
            if (exception is IOException) {
                throw CustomErrorType.NetworkError(exception.message ?: "Unknown NetworkError")
            }
        }
    }

    try {
        return block()
    } catch (exception: Exception) {
        when (exception) {
            is IOException -> throw CustomErrorType.NetworkError(exception.message ?: "Unknown NetworkError")
            is ResponseException -> throw CustomErrorType.ApiError(exception.response?.status?.value ?: 999, exception.message)
            else -> throw CustomErrorType.InternalError(exception.message ?: "Unknown InternalError")
        }
    }
}