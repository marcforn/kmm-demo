package com.mforn.common.configuration.expect

actual class PlatformLogger {

    actual fun logInfo(tag: String, message: String) {
        println("$tag : $message\n")
    }

    actual fun logDebug(tag: String, message: String) {
        print("D-$tag : $message\n")
    }

    actual fun logWarning(tag: String, message: String) {
        println("W-$tag : $message\n")
    }

    actual fun logWarning(tag: String, message: String, exception: Throwable) {
        println("W-$tag : $message\n")
        println(exception)
    }

    actual fun logError(tag: String, message: String) {
        println("E-$tag : $message\n")
    }

    actual fun logError(tag: String, message: String, exception: Throwable) {
        println("E-$tag : $message")
        println(exception)
        println("\n")
    }
}