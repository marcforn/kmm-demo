package com.mforn.kmmdemo.shared.domain.interactor

import com.mforn.kmmdemo.shared.domain.model.RocketLaunch

interface RocketInteractor {

    @Throws(Exception::class)
    suspend fun getLaunches(): List<RocketLaunch>

}