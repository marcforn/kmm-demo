package com.mforn.shared.domain.repository

import com.mforn.common.domain.exception.CustomException
import com.mforn.shared.domain.model.RocketLaunch
import kotlin.coroutines.cancellation.CancellationException

interface RocketRepository {

    @ExperimentalStdlibApi
    @Throws(CustomException::class, CancellationException::class)
    suspend fun getAllLaunches(): List<RocketLaunch>

}