package com.mforn.shared.data.repository

import com.mforn.shared.data.model.mapper.RocketDataMapper
import com.mforn.shared.data.network.RocketApi
import com.mforn.shared.domain.model.RocketLaunch
import com.mforn.shared.domain.repository.RocketRepository


class RocketRepositoryImpl(
    private val rocketApi: RocketApi,
    private val dataMapper: RocketDataMapper
) : RocketRepository {


    override suspend fun getAllLaunches(): List<RocketLaunch>{
        val response = rocketApi.getAllLaunches()

        return dataMapper.mapToDomain(response)
    }

}