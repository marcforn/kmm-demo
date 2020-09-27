package com.mforn.launches.data.network

import com.mforn.common.data.network.coroutine.retryApi
import com.mforn.common.domain.model.exception.CustomException
import com.mforn.launches.data.network.model.response.RocketLaunchDto
import io.ktor.client.*
import io.ktor.client.request.*
import kotlin.coroutines.cancellation.CancellationException


private const val BACKEND_ROOT = "https://api.spacexdata.com"
private const val LAUNCHES_ENDPOINT = "$BACKEND_ROOT/v3/launches"
private const val LAUNCH_INFO_ENDPOINT = "$BACKEND_ROOT/v3/launches"


class LaunchesApi(private val httpClient: HttpClient) {

    @ExperimentalStdlibApi
    @Throws(CustomException::class, CancellationException::class)
    suspend fun getAllLaunches(): List<RocketLaunchDto> {
        return retryApi { httpClient.get(LAUNCHES_ENDPOINT) }
    }

    @ExperimentalStdlibApi
    @Throws(CustomException::class, CancellationException::class)
    suspend fun getLaunchInformation(flightNumber : Int): RocketLaunchDto {
        return retryApi { httpClient.get("$LAUNCH_INFO_ENDPOINT/$flightNumber") }
    }

}

