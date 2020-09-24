package com.mforn.shared.domain.repository

import com.mforn.shared.domain.model.RocketLaunch

interface RocketRepository {

    suspend fun getAllLaunches(): List<RocketLaunch>

}