plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-android-extensions")
    id("com.google.gms.google-services")
    id("com.google.firebase.firebase-perf")
    id("com.google.firebase.crashlytics")
}

repositories {
    gradlePluginPortal()
    google()
    jcenter()
    mavenCentral()
}

dependencies {
    implementation(project(":shared"))

    implementation(Dependencies.android_material)
    implementation(Dependencies.app_compat)
    implementation(Dependencies.constraint_layout)
    implementation(Dependencies.swipe_refresh_layout)
    implementation(Dependencies.card_view)
    implementation(Dependencies.coroutines)
    implementation(Dependencies.core_ktx)
    implementation(Dependencies.recycler_view)
    implementation(Dependencies.firebase_crashlytics)
    implementation(Dependencies.firebase_analytics)
    implementation(Dependencies.firebase_performance)
}

android {
    compileSdkVersion(Versions.compile_sdk)
    defaultConfig {
        applicationId = "com.mforn.kmmdemo"
        minSdkVersion(Versions.min_sdk)
        targetSdkVersion(Versions.target_sdk)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}