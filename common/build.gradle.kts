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

    val ktorVersion = "1.4.0"
    val ktorVersionLogging = "1.3.1"
    val serializationVersion = "1.0.0-RC"
    val coroutinesVersion = "1.3.9-native-mt"

    sourceSets {
        val commonMain by getting{
            dependencies{
                api("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
                api("org.jetbrains.kotlinx:kotlinx-serialization-core:$serializationVersion")
                api("io.ktor:ktor-client-core:$ktorVersion")
                api("io.ktor:ktor-client-serialization:$ktorVersion")
                api("io.ktor:ktor-client-logging:$ktorVersion")
            }
        }
        val androidMain by getting {
            dependencies {
                api("io.ktor:ktor-client-android:$ktorVersion")
                api("io.ktor:ktor-client-logging-jvm:$ktorVersion")
            }
        }
        val iosMain by getting{
            dependencies{
                api("io.ktor:ktor-client-ios:$ktorVersion")
                api("io.ktor:ktor-client-logging-native:$ktorVersionLogging")
            }
        }
    }
}

android {
    compileSdkVersion(29)
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdkVersion(24)
        targetSdkVersion(29)
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
    val framework = kotlin.targets.getByName<org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget>(targetName).binaries.getFramework(mode)
    inputs.property("mode", mode)
    dependsOn(framework.linkTask)
    val targetDir = File(buildDir, "xcode-frameworks")
    from({ framework.outputDirectory })
    into(targetDir)
}
tasks.getByName("build").dependsOn(packForXcode)