package com.mforn.rockets.data.network

import com.mforn.common.data.network.coroutine.retryNetworkApi
import com.mforn.common.domain.model.exception.CustomException
import com.mforn.rockets.data.network.model.response.RocketDto
import io.ktor.client.*
import io.ktor.client.request.*
import kotlin.coroutines.cancellation.CancellationException


private const val BACKEND_ROOT = "https://api.spacexdata.com"
private const val ROCKETS_ENDPOINT = "$BACKEND_ROOT/v3/rockets"


class RocketsApi(private val httpClient: HttpClient) {

    @ExperimentalStdlibApi
    @Throws(CustomException::class, CancellationException::class)
    suspend fun getAllRockets(): List<RocketDto> {
        return retryNetworkApi { httpClient.get(ROCKETS_ENDPOINT) }
    }

    @ExperimentalStdlibApi
    @Throws(CustomException::class, CancellationException::class)
    suspend fun getRocketInformation(rocketId: String): RocketDto {
        return retryNetworkApi { httpClient.get("$ROCKETS_ENDPOINT/$rocketId") }
    }

}

