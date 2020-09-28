package com.mforn.launches.data.model.mapper

import com.mforn.launches.data.network.model.response.LaunchDto
import com.mforn.launches.domain.model.Launch


class LaunchesMapper {

    fun mapLaunchList(data: List<LaunchDto>): List<Launch> {
        val modelList = mutableListOf<Launch>()
        data.forEach { it -> modelList.add(mapLaunch(it)) }
        return modelList
    }

    fun mapLaunch(launchDto: LaunchDto) : Launch{
        return Launch(
            launchDto.flightNumber,
            launchDto.missionName,
            launchDto.launchYear,
            launchDto.details ?: "",
            launchDto.launchSuccess ?: false
        )
    }
}