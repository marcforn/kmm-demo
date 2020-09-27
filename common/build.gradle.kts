import Versions.kotlin

plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("com.android.library")
    id("kotlin-android-extensions")
}

repositories {
    gradlePluginPortal()
    google()
    jcenter()
    mavenCentral()
    maven(url = "https://dl.bintray.com/ekito/koin")
}

kotlin {
    android()
    ios {
        binaries {
            framework {
                baseName = "common"
            }
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(Dependencies.Coroutines.common)
                api(Dependencies.Koin.common)
                api(Dependencies.Ktor.commonCore)
                api(Dependencies.Ktor.commonSerialization)
                api(Dependencies.Ktor.commonLogging)
                //api(Dependencies.BlueFalcon.common) // TODO mforn: 28/09/20 pending fix from BlueFalcon team
            }
        }
        val commonTest by getting {
            dependencies {
                api(Dependencies.Koin.test)
            }
        }
        val androidMain by getting {
            dependencies {
                api(Dependencies.Ktor.android)
            }
        }
        val androidTest by getting
        val iosMain by getting {
            dependencies {
                api(Dependencies.Ktor.ios)
            }
        }
        val iosTest by getting
    }
}

android {
    compileSdkVersion(Versions.compile_sdk)
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
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
}

val packForXcode by tasks.creating(Sync::class) {
    group = "build"
    val mode = System.getenv("CONFIGURATION") ?: "DEBUG"
    val sdkName = System.getenv("SDK_NAME") ?: "iphonesimulator"
    val targetName = "ios" + if (sdkName.startsWith("iphoneos")) "Arm64" else "X64"
    val framework =
        kotlin.targets.getByName<org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget>(
            targetName
        ).binaries.getFramework(mode)
    inputs.property("mode", mode)
    dependsOn(framework.linkTask)
    val targetDir = File(buildDir, "xcode-frameworks")
    from({ framework.outputDirectory })
    into(targetDir)
}
tasks.getByName("build").dependsOn(packForXcode)