package com.mforn.shared.domain.interactor

import com.mforn.shared.domain.model.RocketLaunch

interface RocketInteractor {

    @Throws(Exception::class)
    suspend fun getLaunches(): List<RocketLaunch>

}