package com.mforn.bluetooth.domain.interactor

import com.mforn.bluetooth.domain.model.Peripheral
import com.mforn.bluetooth.domain.repository.BluetoothRepository
import com.mforn.common.domain.coroutine.exceptionHandler
import com.mforn.common.domain.model.exception.CustomException
import org.koin.core.KoinComponent
import org.koin.core.inject
import kotlin.coroutines.cancellation.CancellationException


class BluetoothInteractorImpl : BluetoothInteractor, KoinComponent {

    private val bluetoothRepository: BluetoothRepository by inject()


    @ExperimentalStdlibApi
    @Throws(CustomException::class, CancellationException::class)
    override suspend fun getPeripherals(): List<Peripheral> {
        return exceptionHandler { bluetoothRepository.getPeripherals() }
    }

    @ExperimentalStdlibApi
    @Throws(CustomException::class, CancellationException::class)
    override suspend fun connectPeripheral(peripheral: Peripheral) {
        return exceptionHandler { bluetoothRepository.connectPeripheral(peripheral) }
    }

    @ExperimentalStdlibApi
    @Throws(CustomException::class, CancellationException::class)
    override suspend fun disconnectPeripheral(peripheral: Peripheral) {
        return exceptionHandler { bluetoothRepository.disconnectPeripheral(peripheral) }
    }

}
