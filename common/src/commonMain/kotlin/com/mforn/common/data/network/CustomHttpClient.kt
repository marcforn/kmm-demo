package com.mforn.common.data.network

import com.mforn.common.configuration.expect.platform
import com.mforn.common.configuration.log.CustomLogger
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*

private const val USER_AGENT_HEADER = "User-Agent"
private const val HTTP_TIMEOUT = 5000L


val customHttpClient: HttpClient = HttpClient {

    // Set Default request headers
    defaultRequest {
        header(USER_AGENT_HEADER, platform) // TODO mforn: 10/10/20 get platform version pending framework version
    }

    // Json Configuration
    install(JsonFeature) {
        val json = kotlinx.serialization.json.Json { ignoreUnknownKeys = true }
        serializer = KotlinxSerializer(json)
    }

    // Logging Request/response data
    install(Logging) {
        logger = object : Logger {
            override fun log(message: String) {
                CustomLogger.d("HttpClient", message)
            }
        }
        level = LogLevel.ALL
    }

    // Setup Timeouts
    install(HttpTimeout) {
        requestTimeoutMillis = HTTP_TIMEOUT
        connectTimeoutMillis = HTTP_TIMEOUT
        socketTimeoutMillis = HTTP_TIMEOUT
    }

}