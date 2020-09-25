package com.mforn.shared.domain.interactor

import com.mforn.common.configuration.log.Logger
import com.mforn.shared.configuration.di.LaunchesModule
import com.mforn.shared.domain.model.RocketLaunch
import com.mforn.shared.domain.repository.RocketRepository


class RocketInteractorImpl : RocketInteractor {

    private val rocketRepository: RocketRepository = LaunchesModule().rocketRepository


    @Throws(Exception::class)
    override suspend fun getLaunches(): List<RocketLaunch> {
        Logger.e("Test TAG", "my message") // TODO mforn: 25/09/20 remove log
        return rocketRepository.getAllLaunches()
    }

}
