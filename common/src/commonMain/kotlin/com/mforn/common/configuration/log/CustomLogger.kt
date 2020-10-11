package com.mforn.common.configuration.log

import com.mforn.common.configuration.expect.PlatformLogger
import kotlin.jvm.Volatile
import kotlin.native.concurrent.ThreadLocal


@ThreadLocal // TODO: 16/10/2020 review several instances
object CustomLogger {
    private val platformLogger = PlatformLogger()

    var isDebug: Boolean = false

    fun i(tag: String, message: String) {
        platformLogger.logInfo(tag, message)
    }

    fun d(tag: String, message: String) {
        if (isDebug) {
            platformLogger.logDebug(tag, message)
        }
    }

    fun w(tag: String, message: String, exception: Throwable? = null) {
        if (isDebug) {
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