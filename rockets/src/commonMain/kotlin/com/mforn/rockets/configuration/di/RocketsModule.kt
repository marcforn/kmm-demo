package com.mforn.rockets.configuration.di

import com.mforn.rockets.data.model.mapper.RocketsMapper
import com.mforn.rockets.data.network.RocketsApi
import com.mforn.rockets.data.repository.RocketsRepositoryImpl
import com.mforn.rockets.domain.repository.RocketsRepository
import org.koin.dsl.module


val rocketsModule = module {
    single<RocketsApi> { RocketsApi(get()) }
    single<RocketsMapper> { RocketsMapper() }
    single<RocketsRepository> { RocketsRepositoryImpl(get(), get()) }
}