package com.mforn.common.configuration.di

import com.mforn.common.configuration.log.CustomLogger
import io.ktor.client.*
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import kotlinx.serialization.json.Json
import org.koin.dsl.module


val commonModule = module {
    single<HttpClient> {
        HttpClient {
            install(JsonFeature) {
                val json = Json { ignoreUnknownKeys = true }
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
    }

}