package com.mforn.common.configuration.log

actual class PlatformLogger {

    actual var enabled = true // TODO mforn: 25/09/20 check ios DEBUG status


    actual fun logInfo(tag: String, message: String) {
        println("$tag : $message")
    }

    actual fun logDebug(tag: String, message: String) {
        print("D-$tag : $message")
    }

    actual fun logWarning(tag: String, message: String) {
        println("W-$tag : $message")
    }

    actual fun logWarning(tag: String, message: String, exception: Throwable) {
        println("W-$tag : $message")
        println(exception)
    }

    actual fun logError(tag: String, message: String) {
        println("E-$tag : $message")
    }

    actual fun logError(tag: String, message: String, exception: Throwable) {
        println("E-$tag : $message")
        println(exception)
    }
}