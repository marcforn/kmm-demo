package com.mforn.kmmdemo.shared.data.network

import com.mforn.kmmdemo.shared.data.network.model.RocketLaunchDto
import io.ktor.client.HttpClient
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.*
import kotlinx.serialization.json.Json

class SpaceXApi {
    private val httpClient = HttpClient {
        install(JsonFeature) {
            val json = Json { ignoreUnknownKeys = true }
            serializer = KotlinxSerializer(json)
        }
    }

    @Throws(Exception::class)
    suspend fun getAllLaunches(): List<RocketLaunchDto> {
        return httpClient.get(LAUNCHES_ENDPOINT)
    }

    companion object {
        private const val LAUNCHES_ENDPOINT = "https://api.spacexdata.com/v3/launches"
    }
}

