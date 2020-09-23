package com.mforn.kmmdemo.shared

import com.mforn.kmmdemo.shared.data.network.model.RocketLaunchDto
import com.mforn.kmmdemo.shared.data.network.SpaceXApi

class SpaceXSDK() {
    private val api = SpaceXApi()

    @Throws(Exception::class)
    suspend fun getLaunches(): List<RocketLaunchDto> = api.getAllLaunches()

}
