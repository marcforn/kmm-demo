package com.mforn.bluetooth.configuration.di

import com.mforn.bluetooth.data.model.mapper.BluetoothMapper
import com.mforn.bluetooth.data.repository.BluetoothRepositoryImpl
import com.mforn.bluetooth.domain.repository.BluetoothRepository
import com.mforn.common.data.bluetooth.BluetoothApi
import dev.bluefalcon.BlueFalcon
import org.koin.dsl.module


val bluetoothModule = module {
    single<BluetoothApi> { BluetoothApi(get()) }
    single<BluetoothMapper> { BluetoothMapper() }
    single<BluetoothRepository> { BluetoothRepositoryImpl(get(), get()) }
}