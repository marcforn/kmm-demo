package com.mforn.shared

import com.mforn.common.configuration.log.Logger
import com.mforn.launches.domain.interactor.LaunchesInteractorImpl


private val TAG = SdkManager::class.simpleName!!


/**
 * // TODO mforn: 25/09/20 pending documentation
 */
class SdkManager {

    init {
        Logger.i(TAG, "Initialized")
    }

    val launches = LaunchesInteractorImpl()

}