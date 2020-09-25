package com.mforn.shared.domain.interactor

import com.mforn.common.domain.coroutine.exceptionHandler
import com.mforn.common.domain.exception.CustomException
import com.mforn.shared.configuration.di.LaunchesModule
import com.mforn.shared.domain.model.RocketLaunch
import com.mforn.shared.domain.repository.RocketRepository
import kotlin.coroutines.cancellation.CancellationException


class RocketInteractorImpl : RocketInteractor {

    private val rocketRepository: RocketRepository = LaunchesModule().rocketRepository


    @ExperimentalStdlibApi
    @Throws(CustomException::class, CancellationException::class)
    override suspend fun getLaunches(): List<RocketLaunch> {
        return exceptionHandler { rocketRepository.getAllLaunches()}
    }

}
