package com.mforn.shared

import com.mforn.bluetooth.configuration.di.provideBluetoothModule
import com.mforn.bluetooth.domain.interactor.BluetoothInteractor
import com.mforn.bluetooth.domain.interactor.BluetoothInteractorImpl
import com.mforn.common.configuration.di.provideCommonModule
import com.mforn.common.configuration.expect.PlatformContext
import com.mforn.common.configuration.log.CustomLogger
import com.mforn.common.domain.model.exception.CustomErrorType
import com.mforn.launches.configuration.di.provideLaunchesModule
import com.mforn.launches.domain.interactor.LaunchesInteractor
import com.mforn.launches.domain.interactor.LaunchesInteractorImpl
import com.mforn.rockets.configuration.di.provideRocketsModule
import com.mforn.rockets.domain.interactor.RocketsInteractor
import com.mforn.rockets.domain.interactor.RocketsInteractorImpl
import org.koin.core.context.startKoin


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

    private val launchesInteractor: LaunchesInteractor by lazy { LaunchesInteractorImpl() }
    private val rocketsInteractor: RocketsInteractor by lazy { RocketsInteractorImpl() }
    private val bluetoothInteractor: BluetoothInteractor by lazy { BluetoothInteractorImpl() }

    private var isInitialized = false


    /**
     * Initialize the SDK:
     *  1 - Creating Dependency Injection graph
     *  2 - Set initialized flag as true
     */
    fun initialize(platformContext: PlatformContext) {
        injectModules(platformContext)
        isInitialized = true
        CustomLogger.i(TAG, "Initialized")
    }

    private fun injectModules(platformContext: PlatformContext) {
        startKoin {
            modules(
                provideCommonModule(platformContext),
                provideLaunchesModule(),
                provideRocketsModule(),
                provideBluetoothModule()
            )
        }
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

    /**
     * Provide Bluetooth Service
     */
    fun provideBluetooth(): BluetoothInteractor {
        if (!isInitialized) {
            throw CustomErrorType.NotInitializedError()
        }
        return bluetoothInteractor
    }

}