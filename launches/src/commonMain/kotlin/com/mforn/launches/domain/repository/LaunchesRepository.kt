package com.mforn.launches.domain.repository

import com.mforn.common.domain.model.exception.CustomException
import com.mforn.launches.domain.model.Launch
import kotlin.coroutines.cancellation.CancellationException

interface LaunchesRepository {

    @ExperimentalStdlibApi
    @Throws(CustomException::class, CancellationException::class)
    suspend fun getAllLaunches(): List<Launch>

    @ExperimentalStdlibApi
    @Throws(CustomException::class, CancellationException::class)
    suspend fun getLaunchInformation(flightNumber : Int): Launch

}