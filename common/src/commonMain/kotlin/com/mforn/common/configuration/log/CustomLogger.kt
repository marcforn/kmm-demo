package com.mforn.common.configuration.log

import com.mforn.common.configuration.expect.PlatformLogger


object CustomLogger {
    private val platformLogger = PlatformLogger()

    var enabled
        get() = platformLogger.enabled
        set(value) {
            platformLogger.enabled = value
        }

    fun i(tag: String, message: String) {
        if (enabled) {
            platformLogger.logInfo(tag, message)
        }
    }

    fun d(tag: String, message: String) {
        if (enabled) {
            platformLogger.logDebug(tag, message)
        }
    }

    fun w(tag: String, message: String, exception: Throwable? = null) {
        if (enabled) {
            exception?.let {
                platformLogger.logWarning(tag, message, exception)
            } ?: run {
                platformLogger.logWarning(tag, message)
            }
        }
    }

    fun e(tag: String, message: String, exception: Throwable? = null) {
        exception?.let {
            platformLogger.logError(tag, message, exception)
        } ?: run {
            platformLogger.logError(tag, message)
        }
    }
}