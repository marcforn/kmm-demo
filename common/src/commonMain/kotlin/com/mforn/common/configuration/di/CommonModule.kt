package com.mforn.common.configuration.di

import com.mforn.common.data.bluetooth.BluetoothClient
import com.mforn.common.data.network.customHttpClient
import dev.bluefalcon.BlueFalcon
import io.ktor.client.*
import org.koin.dsl.module


val commonModule = module {
    single<HttpClient> { customHttpClient }
    single<BluetoothClient> { BluetoothClient(BlueFalcon(get(), null)) }
}

