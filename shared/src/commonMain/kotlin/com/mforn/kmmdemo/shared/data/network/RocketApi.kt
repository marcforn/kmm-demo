package com.mforn.kmmdemo.shared.data.network

import com.mforn.kmmdemo.shared.data.network.model.RocketLaunchDto
import io.ktor.client.*
import io.ktor.client.request.*


private const val ROCKET_ENDPOINT = "https://api.spacexdata.com/v3/launches"

class RocketApi(private val httpClient: HttpClient) {

    // TODO mforn: 23/09/20 add retries
    @Throws(Exception::class)
    suspend fun getAllLaunches(): List<RocketLaunchDto> = httpClient.get(ROCKET_ENDPOINT)

}

