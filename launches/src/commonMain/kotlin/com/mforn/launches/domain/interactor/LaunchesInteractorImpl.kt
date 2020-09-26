package com.mforn.launches.domain.interactor

import com.mforn.common.domain.coroutine.exceptionHandler
import com.mforn.common.domain.model.exception.CustomException
import com.mforn.launches.configuration.di.LaunchesModule
import com.mforn.launches.domain.model.RocketLaunch
import com.mforn.launches.domain.repository.LaunchesRepository
import kotlin.coroutines.cancellation.CancellationException


class LaunchesInteractorImpl : LaunchesInteractor {

    private val launchesRepository: LaunchesRepository = LaunchesModule().launchesRepository


    @ExperimentalStdlibApi
    @Throws(CustomException::class, CancellationException::class)
    override suspend fun getLaunches(): List<RocketLaunch> {
        return exceptionHandler { launchesRepository.getAllLaunches()}
    }

}
