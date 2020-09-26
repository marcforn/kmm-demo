package com.mforn.launches.data.repository

import com.mforn.common.domain.model.exception.CustomException
import com.mforn.launches.data.model.mapper.RocketDataMapper
import com.mforn.launches.data.api.LaunchesApi
import com.mforn.launches.domain.model.RocketLaunch
import com.mforn.launches.domain.repository.LaunchesRepository
import kotlin.coroutines.cancellation.CancellationException


class LaunchesRepositoryImpl(
    private val launchesApi: LaunchesApi,
    private val dataMapper: RocketDataMapper
) : LaunchesRepository {


    @ExperimentalStdlibApi
    @Throws(CustomException::class, CancellationException::class)
    override suspend fun getAllLaunches(): List<RocketLaunch>{
        val response = launchesApi.getAllLaunches()
        return dataMapper.mapToDomain(response)
    }

}