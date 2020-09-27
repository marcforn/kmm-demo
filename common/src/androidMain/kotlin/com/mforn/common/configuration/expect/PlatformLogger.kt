package com.mforn.common.configuration.expect

import android.util.Log
import com.mforn.common.android.BuildConfig

actual class PlatformLogger {

    actual var enabled: Boolean = BuildConfig.DEBUG


    actual fun logInfo(tag: String, message: String) {
        Log.i(tag, message)
    }

    actual fun logDebug(tag: String, message: String) {
        Log.d(tag, message)
    }

    actual fun logWarning(tag: String, message: String) {
        Log.e(tag, message)
    }

    actual fun logWarning(tag: String, message: String, exception: Throwable) {
        Log.e(tag, message, exception)
    }

    actual fun logError(tag: String, message: String) {
        Log.e(tag, message)
    }

    actual fun logError(tag: String, message: String, exception: Throwable) {
        Log.e(tag, message, exception)
    }

}