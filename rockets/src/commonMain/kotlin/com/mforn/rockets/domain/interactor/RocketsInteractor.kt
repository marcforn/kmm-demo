package com.mforn.rockets.domain.interactor

import com.mforn.common.domain.model.exception.CustomException
import com.mforn.rockets.domain.model.Rocket
import kotlin.coroutines.cancellation.CancellationException

interface RocketsInteractor {

    @ExperimentalStdlibApi
    @Throws(CustomException::class, CancellationException::class)
    suspend fun getRockets(): List<Rocket>

    @ExperimentalStdlibApi
    @Throws(CustomException::class, CancellationException::class)
    suspend fun getRocketInformation(rocketId : String): Rocket

}