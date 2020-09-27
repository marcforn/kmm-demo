package com.mforn.common.configuration.di

import com.mforn.common.data.network.customHttpClient
import io.ktor.client.*
import org.koin.dsl.module
//import com.mforn.common.data.bluetooth.BluetoothClient
//import dev.bluefalcon.*


val commonModule = module {
    single<HttpClient> { customHttpClient }
//    single<BluetoothClient> { BluetoothClient(BlueFalcon(get(), null)) }
}