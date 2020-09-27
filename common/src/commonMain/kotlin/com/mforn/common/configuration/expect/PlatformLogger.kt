package com.mforn.common.configuration.expect

expect class PlatformLogger() {
    var enabled : Boolean

    fun logInfo(tag: String, message: String)
    fun logDebug(tag: String, message: String)
    fun logWarning(tag: String, message: String)
    fun logWarning(tag: String, message: String, exception: Throwable)
    fun logError(tag: String, message: String)
    fun logError(tag: String, message: String, exception: Throwable)
}