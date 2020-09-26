package com.mforn.launches.domain.interactor

import com.mforn.common.domain.coroutine.exceptionHandler
import com.mforn.common.domain.model.exception.CustomException
import com.mforn.launches.domain.model.RocketLaunch
import com.mforn.launches.domain.repository.LaunchesRepository
import org.koin.core.KoinComponent
import org.koin.core.inject
import kotlin.coroutines.cancellation.CancellationException


class LaunchesInteractorImpl : LaunchesInteractor, KoinComponent {

    private val launchesRepository: LaunchesRepository by inject()


    @ExperimentalStdlibApi
    @Throws(CustomException::class, CancellationException::class)
    override suspend fun getLaunches(): List<RocketLaunch> {
        return exceptionHandler { launchesRepository.getAllLaunches() }
    }

}
