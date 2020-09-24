package com.mforn.kmmdemo.shared.configuration

import com.mforn.common.configuration.CommonModule
import com.mforn.kmmdemo.shared.data.model.mapper.RocketDataMapper
import com.mforn.kmmdemo.shared.data.network.RocketApi
import com.mforn.kmmdemo.shared.data.repository.RocketRepositoryImpl
import com.mforn.kmmdemo.shared.domain.repository.RocketRepository
import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import kotlinx.serialization.json.Json


// TODO mforn: 23/09/20 inject with DI
class LaunchesModule {

    private val rocketApi = RocketApi(CommonModule().httpClient)
    private val dataMapper = RocketDataMapper()
    val rocketRepository: RocketRepository = RocketRepositoryImpl(rocketApi, dataMapper)

}