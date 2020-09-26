package com.mforn.launches.configuration.di

import com.mforn.launches.data.api.LaunchesApi
import com.mforn.launches.data.model.mapper.RocketDataMapper
import com.mforn.launches.data.repository.LaunchesRepositoryImpl
import com.mforn.launches.domain.repository.LaunchesRepository
import org.koin.dsl.module


val launchesModule = module {
    single<LaunchesApi> { LaunchesApi(get()) }
    single<RocketDataMapper> { RocketDataMapper() }
    single<LaunchesRepository> { LaunchesRepositoryImpl(get(), get()) }
}