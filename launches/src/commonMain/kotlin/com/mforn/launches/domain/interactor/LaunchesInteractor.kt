package com.mforn.launches.domain.interactor

import com.mforn.common.domain.model.exception.CustomException
import com.mforn.launches.domain.model.Launch
import kotlin.coroutines.cancellation.CancellationException

interface LaunchesInteractor {

    @ExperimentalStdlibApi
    @Throws(CustomException::class, CancellationException::class)
    suspend fun getLaunches(): List<Launch>

    @ExperimentalStdlibApi
    @Throws(CustomException::class, CancellationException::class)
    suspend fun getLaunchInformation(flightNumber : Int): Launch

}