package com.mforn.rockets.domain.repository

import com.mforn.common.domain.model.exception.CustomException
import com.mforn.rockets.domain.model.Rocket
import kotlin.coroutines.cancellation.CancellationException

interface RocketsRepository {

    @ExperimentalStdlibApi
    @Throws(CustomException::class, CancellationException::class)
    suspend fun getAllRockets(): List<Rocket>

    @ExperimentalStdlibApi
    @Throws(CustomException::class, CancellationException::class)
    suspend fun getRocketInformation(rocketId : String): Rocket

}