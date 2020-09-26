package com.mforn.launches.domain.interactor

import com.mforn.common.domain.model.exception.CustomException
import com.mforn.launches.domain.model.RocketLaunch
import kotlin.coroutines.cancellation.CancellationException

interface LaunchesInteractor {

    @ExperimentalStdlibApi
    @Throws(CustomException::class, CancellationException::class)
    suspend fun getLaunches(): List<RocketLaunch>

}