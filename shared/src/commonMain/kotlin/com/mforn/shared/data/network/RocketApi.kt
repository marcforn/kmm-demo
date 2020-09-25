package com.mforn.shared.data.network

import com.mforn.common.data.coroutine.retryApi
import com.mforn.shared.data.network.model.RocketLaunchDto
import io.ktor.client.*
import io.ktor.client.request.*


private const val BACKEND_ROOT = "https://api.spacexdata.com"
private const val LAUNCH_ENDPOINT = "$BACKEND_ROOT/v3/launches"


class RocketApi(private val httpClient: HttpClient) {

    @Throws(Exception::class)
    suspend fun getAllLaunches(): List<RocketLaunchDto> {
        return retryApi { httpClient.get(LAUNCH_ENDPOINT) }
    }

}

