package com.mforn.shared.domain.interactor

import com.mforn.common.domain.exception.CustomException
import com.mforn.shared.domain.model.RocketLaunch
import kotlin.coroutines.cancellation.CancellationException

interface RocketInteractor {

    @ExperimentalStdlibApi
    @Throws(CustomException::class, CancellationException::class)
    suspend fun getLaunches(): List<RocketLaunch>

}