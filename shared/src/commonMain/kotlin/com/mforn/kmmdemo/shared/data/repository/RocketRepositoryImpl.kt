package com.mforn.kmmdemo.shared.data.repository

import com.mforn.kmmdemo.shared.data.model.mapper.RocketDataMapper
import com.mforn.kmmdemo.shared.data.network.RocketApi
import com.mforn.kmmdemo.shared.domain.model.RocketLaunch
import com.mforn.kmmdemo.shared.domain.repository.RocketRepository


class RocketRepositoryImpl(
    private val rocketApi: RocketApi,
    private val dataMapper: RocketDataMapper
) : RocketRepository {


    override suspend fun getAllLaunches(): List<RocketLaunch>{
        val response = rocketApi.getAllLaunches()

        return dataMapper.mapToDomain(response)
    }

}