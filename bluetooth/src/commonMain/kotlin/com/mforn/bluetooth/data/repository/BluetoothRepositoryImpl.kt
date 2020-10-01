package com.mforn.bluetooth.data.repository

import com.mforn.bluetooth.data.model.mapper.BluetoothMapper
import com.mforn.bluetooth.domain.model.Peripheral
import com.mforn.bluetooth.domain.repository.BluetoothRepository
import com.mforn.common.data.bluetooth.BluetoothApi
import com.mforn.common.domain.model.exception.CustomErrorType
import com.mforn.common.domain.model.exception.CustomException
import kotlin.coroutines.cancellation.CancellationException


class BluetoothRepositoryImpl(
    private val bluetoothApi: BluetoothApi,
    private val dataMapper: BluetoothMapper
) : BluetoothRepository {


    @ExperimentalStdlibApi
    @Throws(CustomException::class, CancellationException::class)
    override suspend fun getPeripherals(): List<Peripheral> {
        val response = bluetoothApi.getPeripherals()
        return dataMapper.mapToPeripheralList(response)
    }

    @ExperimentalStdlibApi
    @Throws(CustomException::class, CancellationException::class)
    override suspend fun connectPeripheral(peripheral: Peripheral) {
        val peripheralList = bluetoothApi.getPeripherals()
        val bluetoothPeripheral = peripheralList.firstOrNull { it.uuid == peripheral.uuid }

        if (bluetoothPeripheral != null) {
            bluetoothApi.connect(bluetoothPeripheral)
        } else {
            throw CustomErrorType.BluetoothError("Peripheral not found (UUID: ${peripheral.uuid})")
        }

    }

    @ExperimentalStdlibApi
    @Throws(CustomException::class, CancellationException::class)
    override suspend fun disconnectPeripheral(peripheral: Peripheral) {
        val bluetoothPeripheral = bluetoothApi.getPeripherals().firstOrNull { it.uuid == peripheral.uuid }

        if (bluetoothPeripheral != null) {
            bluetoothApi.disconnect(bluetoothPeripheral)
        } else {
            throw CustomErrorType.BluetoothError("Peripheral not found (UUID: ${peripheral.uuid})")
        }
    }

}