package com.mforn.common.configuration.di

import com.mforn.common.configuration.expect.PlatformContext
import com.mforn.common.data.network.customHttpClient
import dev.bluefalcon.ApplicationContext
import dev.bluefalcon.BlueFalcon
import io.ktor.client.*
import org.koin.dsl.module


fun provideCommonModule(platformContext: PlatformContext) = module {
    single<HttpClient> { customHttpClient }
    single<BlueFalcon> { BlueFalcon(platformContext as ApplicationContext, null) }
}

