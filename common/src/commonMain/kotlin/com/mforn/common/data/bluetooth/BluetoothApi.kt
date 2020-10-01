package com.mforn.common.data.bluetooth


import com.mforn.common.configuration.log.CustomLogger
import com.mforn.common.domain.model.exception.CustomErrorType
import dev.bluefalcon.*
import kotlinx.coroutines.delay


private val TAG = BluetoothApi::class.simpleName!!

private const val SCANNING_TIME = 5000L
private const val CONNECTING_TIME = 10000L
private const val DISCONNECTING_TIME = 3000L


class BluetoothApi(private val bluetoothClient: BlueFalcon) {

    private val bluetoothDelegate = BluetoothDelegate()


    init {
        bluetoothClient.delegates.add(bluetoothDelegate)
    }

    suspend fun getPeripherals(): List<BluetoothPeripheral> {
        CustomLogger.i(TAG, "Searching for peripherals")

        val peripheralList: MutableList<BluetoothPeripheral> = mutableListOf()
        bluetoothDelegate.deviceDiscoverDelegate = object : DeviceDiscoverDelegate {
            override fun didDiscoverDevice(bluetoothPeripheral: BluetoothPeripheral) {
                if (peripheralList.firstOrNull { it.uuid == bluetoothPeripheral.uuid } == null) {
                    peripheralList.add(bluetoothPeripheral)
                }
            }
        }

        bluetoothClient.scan()
        delay(SCANNING_TIME)
        bluetoothClient.stopScanning()

        return peripheralList
    }

    suspend fun connect(connectPeripheral: BluetoothPeripheral) {
        CustomLogger.i(TAG, "Connecting to: ${connectPeripheral.name}")

        var success = false
        bluetoothDelegate.deviceConnectDelegate = object : DeviceConnectDelegate {
            override fun deviceConnected(bluetoothPeripheral: BluetoothPeripheral) {
                if (bluetoothPeripheral.uuid == connectPeripheral.uuid) {
                    CustomLogger.i(TAG, "Device connected ${bluetoothPeripheral.name}")
                    success = true
                }
            }
        }

        bluetoothClient.connect(connectPeripheral, false)
        delay(CONNECTING_TIME)

        if (!success) {
            throw CustomErrorType.BluetoothError("Unable to connect (UUID: ${connectPeripheral.uuid})")
        }
    }

    suspend fun disconnect(disconnectPeripheral: BluetoothPeripheral) {
        CustomLogger.i(TAG, "Disconnecting from: ${disconnectPeripheral.name}")

        var success = false
        bluetoothDelegate.devicesDisconnectDelegate = object : DeviceDisconnectDelegate {
            override fun deviceDisconnected(bluetoothPeripheral: BluetoothPeripheral) {
                if (bluetoothPeripheral.uuid == disconnectPeripheral.uuid) {
                    CustomLogger.w(TAG, "Device disconnected ${bluetoothPeripheral.name}")
                    success = true
                }
            }
        }

        bluetoothClient.disconnect(disconnectPeripheral)
        delay(DISCONNECTING_TIME)

        if (!success) {
            throw CustomErrorType.BluetoothError("Unable to disconnect (UUID: ${disconnectPeripheral.uuid})")
        }
    }


    internal class BluetoothDelegate : BlueFalconDelegate {
        var deviceDiscoverDelegate: DeviceDiscoverDelegate? = null
        var deviceConnectDelegate: DeviceConnectDelegate? = null
        var devicesDisconnectDelegate: DeviceDisconnectDelegate? = null

        override fun didDiscoverDevice(bluetoothPeripheral: BluetoothPeripheral) {
            deviceDiscoverDelegate?.didDiscoverDevice(bluetoothPeripheral)
        }

        override fun didConnect(bluetoothPeripheral: BluetoothPeripheral) {
            deviceConnectDelegate?.deviceConnected(bluetoothPeripheral)
        }

        override fun didDisconnect(bluetoothPeripheral: BluetoothPeripheral) {
            devicesDisconnectDelegate?.deviceDisconnected(bluetoothPeripheral)
        }

        override fun didDiscoverServices(bluetoothPeripheral: BluetoothPeripheral) {
            // N/A
        }

        override fun didReadDescriptor(bluetoothPeripheral: BluetoothPeripheral, bluetoothCharacteristicDescriptor: BluetoothCharacteristicDescriptor) {
            // N/A
        }

        override fun didCharacteristcValueChanged(bluetoothPeripheral: BluetoothPeripheral, bluetoothCharacteristic: BluetoothCharacteristic) {
        }

        override fun didDiscoverCharacteristics(bluetoothPeripheral: BluetoothPeripheral) {
            // N/A
        }

        override fun didUpdateMTU(bluetoothPeripheral: BluetoothPeripheral) {
            // N/A
        }

        override fun didRssiUpdate(bluetoothPeripheral: BluetoothPeripheral) {
            // N/A
        }
    }
}


internal interface DeviceDiscoverDelegate {
    fun didDiscoverDevice(bluetoothPeripheral: BluetoothPeripheral)
}

internal interface DeviceConnectDelegate {
    fun deviceConnected(bluetoothPeripheral: BluetoothPeripheral)
}

internal interface DeviceDisconnectDelegate {
    fun deviceDisconnected(bluetoothPeripheral: BluetoothPeripheral)
}
