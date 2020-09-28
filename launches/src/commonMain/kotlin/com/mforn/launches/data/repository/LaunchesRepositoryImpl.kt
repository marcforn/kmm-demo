package com.mforn.launches.data.repository

import com.mforn.common.domain.model.exception.CustomException
import com.mforn.launches.data.model.mapper.LaunchesMapper
import com.mforn.launches.data.network.LaunchesApi
import com.mforn.launches.domain.model.Launch
import com.mforn.launches.domain.repository.LaunchesRepository
import kotlin.coroutines.cancellation.CancellationException


class LaunchesRepositoryImpl(
    private val launchesApi: LaunchesApi,
    private val dataMapper: LaunchesMapper
) : LaunchesRepository {


    @ExperimentalStdlibApi
    @Throws(CustomException::class, CancellationException::class)
    override suspend fun getAllLaunches(): List<Launch>{
        val response = launchesApi.getAllLaunches()
        return dataMapper.mapLaunchList(response)
    }

    @ExperimentalStdlibApi
    @Throws(CustomException::class, CancellationException::class)
    override suspend fun getLaunchInformation(flightNumber : Int): Launch {
        val response = launchesApi.getLaunchInformation(flightNumber)

        return dataMapper.mapLaunch(response)
    }

}