package com.mforn.shared.data.model.mapper

import com.mforn.common.data.mapper.DataMapper
import com.mforn.shared.data.network.model.RocketLaunchDto
import com.mforn.shared.domain.model.RocketLaunch

class RocketDataMapper : DataMapper<List<RocketLaunchDto>, List<RocketLaunch>> {

    override fun mapToDomain(data: List<RocketLaunchDto>): List<RocketLaunch> {
        val modelList = mutableListOf<RocketLaunch>()
        data.forEach { it -> modelList.add(mapItem(it)) }

        return modelList
    }

    private fun mapItem(rocketLaunchDto: RocketLaunchDto) : RocketLaunch{
        return RocketLaunch(
            rocketLaunchDto.flightNumber,
            rocketLaunchDto.missionName,
            rocketLaunchDto.launchYear,
            rocketLaunchDto.details ?: "",
            rocketLaunchDto.launchSuccess ?: false
        )
    }
}