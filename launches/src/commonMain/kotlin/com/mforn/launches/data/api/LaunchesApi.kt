package com.mforn.launches.data.api

import com.mforn.common.data.coroutine.retryApi
import com.mforn.common.domain.model.exception.CustomException
import com.mforn.launches.data.api.model.response.RocketLaunchDto
import io.ktor.client.*
import io.ktor.client.request.*
import kotlin.coroutines.cancellation.CancellationException


private const val BACKEND_ROOT = "https://api.spacexdata.com"
private const val LAUNCH_ENDPOINT = "$BACKEND_ROOT/v3/launches"


class LaunchesApi(private val httpClient: HttpClient) {

    @ExperimentalStdlibApi
    @Throws(CustomException::class, CancellationException::class)
    suspend fun getAllLaunches(): List<RocketLaunchDto> {
        return retryApi { httpClient.get(LAUNCH_ENDPOINT) }
    }

}

