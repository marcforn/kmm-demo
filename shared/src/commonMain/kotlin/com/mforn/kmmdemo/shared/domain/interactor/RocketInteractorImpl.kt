package com.mforn.kmmdemo.shared.domain.interactor

import com.mforn.kmmdemo.shared.domain.model.RocketLaunch
import com.mforn.kmmdemo.shared.domain.repository.RocketRepository


class RocketInteractorImpl(private val rocketRepository: RocketRepository) : RocketInteractor {

    @Throws(Exception::class)
    override suspend fun getLaunches(): List<RocketLaunch> = rocketRepository.getAllLaunches()

}
