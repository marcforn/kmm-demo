object Versions {
    const val min_sdk = 21
    const val target_sdk = 30
    const val compile_sdk = 30

    const val kotlin = "1.4.10"
    const val gradle_plugin = "4.1.0-rc03"
    const val google_services_plugin = "4.3.4"
    const val firebase_crashlytics_plugin = "2.3.0"
    const val firebase_performance_plugin = "1.3.1"

    const val android_material = "1.2.1"
    const val app_compat = "1.2.0"
    const val constraint_layout = "2.0.1"
    const val swipe_refresh_layout = "1.1.0"
    const val card_view = "1.0.0"
    const val core_ktx = "1.3.1"
    const val recycler_view = "1.1.0"
    const val firebase_crashlytics = "17.2.2"
    const val firebase_analytics = "17.5.0"
    const val firebase_performance = "19.0.9"

    const val coroutines = "1.3.9-native-mt-2"
    const val ktor = "1.4.1"
    const val koin = "3.0.0-alpha-4"
    const val blue_falcon = "0.8.0"
}

object Dependencies {

    //region Android App Dependencies
    const val android_material = "com.google.android.material:material:${Versions.android_material}"
    const val app_compat = "androidx.appcompat:appcompat:${Versions.app_compat}"
    const val constraint_layout = "androidx.constraintlayout:constraintlayout:${Versions.constraint_layout}"
    const val swipe_refresh_layout = "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swipe_refresh_layout}"
    const val card_view = "androidx.cardview:cardview:${Versions.card_view}"
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    const val core_ktx = "androidx.core:core-ktx:${Versions.core_ktx}"
    const val recycler_view = "androidx.recyclerview:recyclerview:${Versions.recycler_view}"
    const val firebase_crashlytics = "com.google.firebase:firebase-crashlytics-ktx:${Versions.firebase_crashlytics}"
    const val firebase_analytics = "com.google.firebase:firebase-analytics-ktx:${Versions.firebase_analytics}"
    const val firebase_performance = "com.google.firebase:firebase-perf-ktx:${Versions.firebase_performance}"
    //endregion


    //region KMM Dependencies
    object Coroutines {
        const val common = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    }

    object Ktor {
        const val commonCore = "io.ktor:ktor-client-core:${Versions.ktor}"
        const val commonLogging = "io.ktor:ktor-client-logging:${Versions.ktor}"
        const val commonSerialization = "io.ktor:ktor-client-serialization:${Versions.ktor}"
        const val android = "io.ktor:ktor-client-android:${Versions.ktor}"
        const val ios = "io.ktor:ktor-client-ios:${Versions.ktor}"
    }

    object Koin {
        const val common = "org.koin:koin-core:${Versions.koin}"
        const val test = "org.koin:koin-test:${Versions.koin}"
    }

    object BlueFalcon {
        const val common = "dev.bluefalcon:library:${Versions.blue_falcon}"
    }

    object KotlinTest {
        const val common = "org.jetbrains.kotlin:kotlin-test-common:${Versions.kotlin}"
        const val commonAnnotations = "org.jetbrains.kotlin:kotlin-test-annotations-common:${Versions.kotlin}"
    }
    //endregion

}
