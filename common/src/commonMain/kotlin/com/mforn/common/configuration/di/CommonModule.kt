package com.mforn.common.configuration.di

import io.ktor.client.*
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.features.logging.Logger
import kotlinx.serialization.json.Json


// TODO mforn: 23/09/20 inject with DI
class CommonModule {

    val httpClient = HttpClient {
        install(JsonFeature) {
            val json = Json { ignoreUnknownKeys = true }
            serializer = KotlinxSerializer(json)
        }

        install(Logging) {
            logger = Logger.SIMPLE
            level = LogLevel.ALL // TODO mforn: 25/09/20 check debug vs release
        }
    }

}