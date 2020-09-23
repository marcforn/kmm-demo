package com.mforn.kmmdemo.shared.domain.repository

import com.mforn.kmmdemo.shared.domain.model.RocketLaunch

interface RocketRepository {

    suspend fun getAllLaunches(): List<RocketLaunch>

}