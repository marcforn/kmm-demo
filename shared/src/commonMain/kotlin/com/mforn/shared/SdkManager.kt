package com.mforn.shared

import com.mforn.bluetooth.configuration.di.bluetoothModule
import com.mforn.bluetooth.domain.interactor.BluetoothInteractor
import com.mforn.bluetooth.domain.interactor.BluetoothInteractorImpl
import com.mforn.common.configuration.di.commonModule
import com.mforn.common.configuration.expect.ApplicationContext
import com.mforn.common.configuration.log.CustomLogger
import com.mforn.common.domain.model.exception.CustomErrorType
import com.mforn.launches.configuration.di.launchesModule
import com.mforn.launches.domain.interactor.LaunchesInteractor
import com.mforn.launches.domain.interactor.LaunchesInteractorImpl
import com.mforn.rockets.configuration.di.rocketsModule
import com.mforn.rockets.domain.interactor.RocketsInteractor
import com.mforn.rockets.domain.interactor.RocketsInteractorImpl
import dev.bluefalcon.BlueFalcon
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

    private val launchesInteractor: LaunchesInteractor by lazy { LaunchesInteractorImpl() }
    private val rocketsInteractor: RocketsInteractor by lazy { RocketsInteractorImpl() }
    private val bluetoothInteractor: BluetoothInteractor by lazy { BluetoothInteractorImpl() }

    private var isInitialized = false


    /**
     * Initialize the SDK:
     *  1 - Creating Dependency Injection graph
     *  2 - Set initialized flag as true
     */
    fun initialize(applicationContext: ApplicationContext) {
        injectModules(applicationContext)
        isInitialized = true
        CustomLogger.i(TAG, "Initialized")
    }

    private fun injectModules(applicationContext: ApplicationContext) {
        // TODO mforn: 28/09/20 kclass conflict on iOS
        val removeModule = module {
            single<BlueFalcon> { BlueFalcon(applicationContext, null) }
//            single<ApplicationContext> { applicationContext}
        }

        startKoin {
            modules(
                removeModule,
                commonModule,
                launchesModule,
                rocketsModule,
                bluetoothModule
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