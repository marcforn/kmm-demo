package com.mforn.launches.configuration.di

import com.mforn.launches.data.network.LaunchesApi
import com.mforn.launches.data.model.mapper.LaunchesMapper
import com.mforn.launches.data.repository.LaunchesRepositoryImpl
import com.mforn.launches.domain.repository.LaunchesRepository
import org.koin.dsl.module


val launchesModule = module {
    single<LaunchesApi> { LaunchesApi(get()) }
    single<LaunchesMapper> { LaunchesMapper() }
    single<LaunchesRepository> { LaunchesRepositoryImpl(get(), get()) }
}