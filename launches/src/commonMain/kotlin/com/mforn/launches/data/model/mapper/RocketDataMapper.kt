package com.mforn.launches.data.model.mapper

import com.mforn.common.data.model.mapper.DataMapper
import com.mforn.launches.data.network.model.response.RocketLaunchDto
import com.mforn.launches.domain.model.RocketLaunch


// TODO mforn: 28/09/20 handle mapper
class RocketDataMapper : DataMapper<List<RocketLaunchDto>, List<RocketLaunch>> {

    override fun mapToDomain(data: List<RocketLaunchDto>): List<RocketLaunch> {
        val modelList = mutableListOf<RocketLaunch>()
        data.forEach { it -> modelList.add(mapItem(it)) }

        return modelList
    }

    fun mapItem(rocketLaunchDto: RocketLaunchDto) : RocketLaunch{
        return RocketLaunch(
            rocketLaunchDto.flightNumber,
            rocketLaunchDto.missionName,
            rocketLaunchDto.launchYear,
            rocketLaunchDto.details ?: "",
            rocketLaunchDto.launchSuccess ?: false
        )
    }
}