package com.mforn.common.data.network

import com.mforn.common.configuration.log.CustomLogger
import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*


val customHttpClient : HttpClient = HttpClient {
    install(JsonFeature) {
        val json = kotlinx.serialization.json.Json { ignoreUnknownKeys = true }
        serializer = KotlinxSerializer(json)
    }

    install(Logging) {
        logger = object : Logger {
            override fun log(message: String) {
                CustomLogger.i("HttpClient", message)
            }

        }
        level = LogLevel.ALL // TODO mforn: 25/09/20 check debug vs release
    }
}