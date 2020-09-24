package com.mforn.shared.configuration

import com.mforn.common.configuration.CommonModule
import com.mforn.shared.data.model.mapper.RocketDataMapper
import com.mforn.shared.data.network.RocketApi
import com.mforn.shared.data.repository.RocketRepositoryImpl
import com.mforn.shared.domain.repository.RocketRepository


// TODO mforn: 23/09/20 inject with DI
class LaunchesModule {

    private val rocketApi = RocketApi(CommonModule().httpClient)
    private val dataMapper = RocketDataMapper()
    val rocketRepository: RocketRepository = RocketRepositoryImpl(rocketApi, dataMapper)

}