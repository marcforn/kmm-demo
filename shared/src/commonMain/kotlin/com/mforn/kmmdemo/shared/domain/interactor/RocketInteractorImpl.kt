package com.mforn.kmmdemo.shared.domain.interactor

import com.mforn.kmmdemo.shared.configuration.LaunchesModule
import com.mforn.kmmdemo.shared.domain.model.RocketLaunch
import com.mforn.kmmdemo.shared.domain.repository.RocketRepository


class RocketInteractorImpl : RocketInteractor {

    private val rocketRepository: RocketRepository = LaunchesModule().rocketRepository


    @Throws(Exception::class)
    override suspend fun getLaunches(): List<RocketLaunch> = rocketRepository.getAllLaunches()

}
