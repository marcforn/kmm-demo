package com.mforn.rockets.data.model.mapper

import com.mforn.rockets.data.network.model.response.RocketDto
import com.mforn.rockets.domain.model.Rocket


class RocketsMapper {

    fun mapToRocketList(data: List<RocketDto>): List<Rocket> {
        val modelList = mutableListOf<Rocket>()
        data.forEach { it -> modelList.add(mapToRocket(it)) }
        return modelList
    }

    fun mapToRocket(launchDto: RocketDto) : Rocket{
        return Rocket(
            launchDto.id,
            launchDto.name,
            launchDto.boosters,
            launchDto.cost,
            launchDto.successRate,
            launchDto.images
        )
    }

}