package com.mforn.launches.domain.repository

import com.mforn.common.domain.model.exception.CustomException
import com.mforn.launches.domain.model.RocketLaunch
import kotlin.coroutines.cancellation.CancellationException

interface LaunchesRepository {

    @ExperimentalStdlibApi
    @Throws(CustomException::class, CancellationException::class)
    suspend fun getAllLaunches(): List<RocketLaunch>

    @ExperimentalStdlibApi
    @Throws(CustomException::class, CancellationException::class)
    suspend fun getLaunchInformation(launchId : Int): RocketLaunch

}