package com.mforn.rockets.domain.interactor

import com.mforn.common.domain.coroutine.exceptionHandler
import com.mforn.common.domain.model.exception.CustomException
import com.mforn.rockets.domain.model.Rocket
import com.mforn.rockets.domain.repository.RocketsRepository
import org.koin.core.KoinComponent
import org.koin.core.inject
import kotlin.coroutines.cancellation.CancellationException

class RocketsInteractorImpl : RocketsInteractor, KoinComponent {

    private val rocketsRepository: RocketsRepository by inject()


    @ExperimentalStdlibApi
    @Throws(CustomException::class, CancellationException::class)
    override suspend fun getRockets(): List<Rocket> {
        return exceptionHandler { rocketsRepository.getAllRockets() }
    }

    @ExperimentalStdlibApi
    @Throws(CustomException::class, CancellationException::class)
    override suspend fun getRocketInformation(rocketId: String): Rocket {
        return exceptionHandler { rocketsRepository.getRocketInformation(rocketId) }
    }
}