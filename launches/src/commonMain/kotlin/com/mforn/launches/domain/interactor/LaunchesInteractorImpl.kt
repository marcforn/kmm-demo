package com.mforn.launches.domain.interactor

import com.mforn.common.domain.coroutine.exceptionHandler
import com.mforn.common.domain.model.exception.CustomException
import com.mforn.launches.domain.model.Launch
import com.mforn.launches.domain.repository.LaunchesRepository
import org.koin.core.KoinComponent
import org.koin.core.inject
import kotlin.coroutines.cancellation.CancellationException


class LaunchesInteractorImpl : LaunchesInteractor, KoinComponent {

    private val launchesRepository: LaunchesRepository by inject()


    @ExperimentalStdlibApi
    @Throws(CustomException::class, CancellationException::class)
    override suspend fun getLaunches(): List<Launch> {
        return exceptionHandler { launchesRepository.getAllLaunches() }
    }

    @ExperimentalStdlibApi
    @Throws(CustomException::class, CancellationException::class)
    override suspend fun getLaunchInformation(flightNumber: Int): Launch {
        return exceptionHandler { launchesRepository.getLaunchInformation(flightNumber) }
    }

}
