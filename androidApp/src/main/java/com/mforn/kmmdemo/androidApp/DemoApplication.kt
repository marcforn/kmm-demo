package com.mforn.kmmdemo.androidApp

import android.app.Application
import com.mforn.shared.SdkManager


lateinit var sdkManager: SdkManager


class DemoApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        sdkManager = SdkManager()
        sdkManager.initialize(this)
    }

}