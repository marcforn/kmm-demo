package com.mforn.shared.domain.interactor

import com.mforn.common.domain.coroutine.exceptionHandler
import com.mforn.shared.configuration.di.LaunchesModule
import com.mforn.shared.domain.model.RocketLaunch
import com.mforn.shared.domain.repository.RocketRepository


class RocketInteractorImpl : RocketInteractor {

    private val rocketRepository: RocketRepository = LaunchesModule().rocketRepository


    @Throws(Exception::class)
    override suspend fun getLaunches(): List<RocketLaunch> {
        return exceptionHandler { rocketRepository.getAllLaunches()}
    }

}
