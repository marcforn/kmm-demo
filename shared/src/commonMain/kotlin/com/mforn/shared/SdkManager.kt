package com.mforn.shared

import com.mforn.common.configuration.di.commonModule
import com.mforn.common.configuration.expect.ApplicationContext
import com.mforn.common.configuration.log.CustomLogger
import com.mforn.common.domain.model.exception.CustomErrorType
import com.mforn.launches.configuration.di.launchesModule
import com.mforn.launches.domain.interactor.LaunchesInteractor
import com.mforn.launches.domain.interactor.LaunchesInteractorImpl
import org.koin.core.context.startKoin
import org.koin.dsl.module


private val TAG = SdkManager::class.simpleName!!


/**
 * SdkManager: Bridge between all module features and native applications.
 *
 *  1 - LaunchService: Handle all SpaceX launches information
 *
 *
 * For invoking any method initialize method is required otherwise NotInitializedError will be thrown
 */
class SdkManager {

    private lateinit var appContext: ApplicationContext

    /**
     * Initialize the SDK:
     *  1 - Creating Dependency Injection graph
     *  2 - Set initialized flag as true
     */
    fun initialize(applicationContext: ApplicationContext) {
        appContext = applicationContext
        initKoin()
        CustomLogger.i(TAG, "Initialized")
    }

    private fun initKoin() {
        val appModule = module {
            single<ApplicationContext> { appContext }
        }
        startKoin {
            modules(
                appModule,
                commonModule,
                launchesModule
            )
        }
    }

    /**
     * Provide Launches Service
     */
    fun provideLaunches(): LaunchesInteractor {
        if (!::appContext.isInitialized) {
            throw CustomErrorType.NotInitializedError()
        }
        return LaunchesInteractorImpl()
    }

}