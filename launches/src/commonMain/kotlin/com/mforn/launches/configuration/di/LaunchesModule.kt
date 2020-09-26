package com.mforn.launches.configuration.di

import com.mforn.common.configuration.di.CommonModule
import com.mforn.launches.data.model.mapper.RocketDataMapper
import com.mforn.launches.data.api.LaunchesApi
import com.mforn.launches.data.repository.LaunchesRepositoryImpl
import com.mforn.launches.domain.repository.LaunchesRepository


// TODO mforn: 23/09/20 inject with DI
class LaunchesModule {

    private val rocketApi = LaunchesApi(CommonModule().httpClient)
    private val dataMapper = RocketDataMapper()
    val launchesRepository: LaunchesRepository = LaunchesRepositoryImpl(rocketApi, dataMapper)

}