package com.mforn.bluetooth.data.model.mapper

import com.mforn.bluetooth.domain.model.Peripheral
import dev.bluefalcon.BluetoothPeripheral


class BluetoothMapper {

    fun mapToPeripheralList(data: List<BluetoothPeripheral>): List<Peripheral> {
        val modelList = mutableListOf<Peripheral>()
        data.forEach { it -> modelList.add(mapToPeripheral(it)) }
        return modelList
    }

    fun mapToPeripheral(bluetoothPeripheral: BluetoothPeripheral) : Peripheral{
        return Peripheral(
            bluetoothPeripheral.uuid,
            bluetoothPeripheral.name,
        )
    }

}