package com.mforn.rockets.data.repository

import com.mforn.common.domain.model.exception.CustomException
import com.mforn.rockets.data.model.mapper.RocketsMapper
import com.mforn.rockets.data.network.RocketsApi
import com.mforn.rockets.domain.model.Rocket
import com.mforn.rockets.domain.repository.RocketsRepository
import kotlin.coroutines.cancellation.CancellationException


class RocketsRepositoryImpl(
    private val rocketsApi: RocketsApi,
    private val rocketsMapper: RocketsMapper
) : RocketsRepository {


    @ExperimentalStdlibApi
    @Throws(CustomException::class, CancellationException::class)
    override suspend fun getAllRockets(): List<Rocket> {
        val response = rocketsApi.getAllRockets()
        return rocketsMapper.mapToRocketList(response)
    }

    @ExperimentalStdlibApi
    @Throws(CustomException::class, CancellationException::class)
    override suspend fun getRocketInformation(rocketId: String): Rocket {
        val response = rocketsApi.getRocketInformation(rocketId)
        return rocketsMapper.mapToRocket(response)
    }


}