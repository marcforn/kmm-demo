package com.mforn.shared

import com.mforn.common.configuration.di.commonModule
import com.mforn.common.configuration.expect.ApplicationContext
import com.mforn.common.configuration.log.CustomLogger
import com.mforn.common.data.bluetooth.BluetoothClient
import com.mforn.common.data.bluetooth.DeviceCharacteristicDelegate
import com.mforn.common.data.bluetooth.DeviceConnectDelegate
import com.mforn.common.data.bluetooth.DevicesDelegate
import com.mforn.common.domain.model.exception.CustomErrorType
import com.mforn.launches.configuration.di.launchesModule
import com.mforn.launches.domain.interactor.LaunchesInteractor
import com.mforn.launches.domain.interactor.LaunchesInteractorImpl
import com.mforn.rockets.configuration.di.rocketsModule
import com.mforn.rockets.domain.interactor.RocketsInteractor
import com.mforn.rockets.domain.interactor.RocketsInteractorImpl
import dev.bluefalcon.BlueFalcon
import dev.bluefalcon.BluetoothPeripheral
import org.koin.core.context.startKoin
import org.koin.dsl.module



private val TAG = SdkManager::class.simpleName!!


/**
 * SdkManager: Bridge between all module features and native applications.
 *
 *  1 - Launches: Handle all SpaceX launches information
 *  1 - Rockets: Handle all SpaceX rockets information
 *
 *
 * For invoking any method initialize method is required otherwise NotInitializedError will be thrown
 */
class SdkManager {

    private lateinit var bluetoothClient: BluetoothClient
    private var isInitialized = false

    private val launchesInteractor : LaunchesInteractor by lazy { LaunchesInteractorImpl() }
    private val rocketsInteractor : RocketsInteractor by lazy { RocketsInteractorImpl() }


    /**
     * Initialize the SDK:
     *  1 - Creating Dependency Injection graph
     *  2 - Set initialized flag as true
     */
    fun initialize(applicationContext: ApplicationContext) {
        initKoin(applicationContext)
        isInitialized = true
        CustomLogger.i(TAG, "Initialized")
    }

    private fun initKoin(applicationContext: ApplicationContext) {
        // TODO mforn: 28/09/20 kclass conflict on iOS
//        val appModule = module {
//            single<ApplicationContext> { applicationContext }
//        }

        startKoin {
            modules(
//                appModule,
                commonModule,
                launchesModule,
                rocketsModule
            )
        }

        bluetoothClient = BluetoothClient(BlueFalcon(applicationContext, null))
        bluetoothClient.addDevicesDelegate(object : DevicesDelegate{
            override fun didDiscoverDevice(bluetoothPeripheral: BluetoothPeripheral) {
                CustomLogger.e("MFR", "Device Found")
            }
        })
        bluetoothClient.addDeviceCharacteristicDelegate(object : DeviceCharacteristicDelegate{
            override fun didCharacteristcValueChanged(value: String) {
                CustomLogger.e("MFR", "Device Characteristic")
            }

        })
        bluetoothClient.addDeviceConnectDelegate(object : DeviceConnectDelegate{
            override fun didDeviceConnect(bluetoothPeripheral: BluetoothPeripheral) {
                CustomLogger.e("MFR", "Device Connect")
            }

            override fun didDiscoverServices(bluetoothPeripheral: BluetoothPeripheral) {
                CustomLogger.e("MFR", "Device Discovered")
            }

            override fun didRssiChange(bluetoothPeripheral: BluetoothPeripheral) {
                CustomLogger.e("MFR", "Device RSSI Change")
            }

        })
    }

    /**
     * Provide Launches Service
     */
    fun provideLaunches(): LaunchesInteractor {
        if (!isInitialized) {
            throw CustomErrorType.NotInitializedError()
        }
        return launchesInteractor
    }


    /**
     * Provide Rockets Service
     */
    fun provideRockets(): RocketsInteractor {
        if (!isInitialized) {
            throw CustomErrorType.NotInitializedError()
        }
        return rocketsInteractor
    }

    fun provideBluetooth() : BluetoothClient =  bluetoothClient

}