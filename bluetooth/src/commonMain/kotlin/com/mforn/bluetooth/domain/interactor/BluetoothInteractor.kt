package com.mforn.bluetooth.domain.interactor

import com.mforn.bluetooth.domain.model.Peripheral
import com.mforn.common.domain.model.exception.CustomException
import kotlin.coroutines.cancellation.CancellationException


interface BluetoothInteractor {

    @ExperimentalStdlibApi
    @Throws(CustomException::class, CancellationException::class)
    suspend fun getPeripherals(): List<Peripheral>

    @ExperimentalStdlibApi
    @Throws(CustomException::class, CancellationException::class)
    suspend fun connectPeripheral(peripheral: Peripheral)

    @ExperimentalStdlibApi
    @Throws(CustomException::class, CancellationException::class)
    suspend fun disconnectPeripheral(peripheral: Peripheral)

}