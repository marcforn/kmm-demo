package com.mforn.launches.data.model.mapper

import com.mforn.launches.data.network.model.response.LaunchDto
import com.mforn.launches.domain.model.Launch


class LaunchesMapper {

    fun mapToLaunchList(data: List<LaunchDto>): List<Launch> {
        val modelList = mutableListOf<Launch>()
        data.forEach { it -> modelList.add(mapToLaunch(it)) }
        return modelList
    }

    fun mapToLaunch(launchDto: LaunchDto) : Launch{
        return Launch(
            launchDto.flightNumber,
            launchDto.missionName,
            launchDto.launchYear,
            launchDto.details ?: "",
            launchDto.launchSuccess ?: false
        )
    }
}