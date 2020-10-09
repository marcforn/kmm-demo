package com.mforn.common.data.network

import com.mforn.common.configuration.log.CustomLogger
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

private const val USER_AGENT_HEADER = "User-Agent"
private const val HTTP_TIMEOUT = 5000L



val customHttpClient : HttpClient = HttpClient {

    // Set Default request headers
    defaultRequest {
        header(USER_AGENT_HEADER, "MyValue") // TODO mforn: 10/10/20 get operative version
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
                CustomLogger.i("HttpClient", message)
            }

        }
        level = LogLevel.ALL // TODO mforn: 25/09/20 check debug vs release
    }

    // Setup Timeouts
    install(HttpTimeout) {
        requestTimeoutMillis = HTTP_TIMEOUT
        connectTimeoutMillis = HTTP_TIMEOUT
        socketTimeoutMillis = HTTP_TIMEOUT
    }

    // TODO mforn: 10/10/20 add retries logic here
    HttpResponseValidator {
        validateResponse { response: HttpResponse ->
            CustomLogger.w("MFR", "Response received")
        }

        handleResponseException { cause: Throwable ->
            CustomLogger.w("MFR", "Exception thrown")
        }
    }

}