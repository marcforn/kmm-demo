package com.mforn.kmmdemo.shared.domain.interactor

import com.mforn.common.configuration.CommonModule
import com.mforn.kmmdemo.shared.data.model.mapper.RocketDataMapper
import com.mforn.kmmdemo.shared.data.network.RocketApi
import com.mforn.kmmdemo.shared.data.repository.RocketRepositoryImpl
import com.mforn.kmmdemo.shared.domain.model.RocketLaunch
import com.mforn.kmmdemo.shared.domain.repository.RocketRepository
//import io.ktor.client.*
//import io.ktor.client.features.json.JsonFeature
//import io.ktor.client.features.json.serializer.*
//import kotlinx.serialization.json.Json


class RocketInteractorImpl : RocketInteractor {


    // TODO mforn: 23/09/20 inject with DI
//    private val httpClient = HttpClient {
//        install(JsonFeature) {
//            val json = Json { ignoreUnknownKeys = true }
//            serializer = KotlinxSerializer(json)
//        }
//    }
    private val rocketApi = RocketApi(CommonModule.httpClient)
    private val dataMapper = RocketDataMapper()
    private val rocketRepository: RocketRepository = RocketRepositoryImpl(rocketApi, dataMapper)


    @Throws(Exception::class)
    override suspend fun getLaunches(): List<RocketLaunch> = rocketRepository.getAllLaunches()

}
