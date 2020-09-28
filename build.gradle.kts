buildscript {
    repositories {
        gradlePluginPortal()
        jcenter()
        google()
        mavenCentral()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:${Versions.gradle_plugin}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin_plugin}")
        classpath("org.jetbrains.kotlin:kotlin-serialization:${Versions.kotlin_plugin}")
        classpath("com.google.gms:google-services:${Versions.google_services_plugin}")
        classpath("com.google.firebase:firebase-crashlytics-gradle:${Versions.firebase_crashlytics_plugin}")
        classpath("com.google.firebase:perf-plugin:${Versions.firebase_performance_plugin}")
    }
}


allprojects {
    repositories {
        google()
        mavenCentral()
        maven(url = "https://dl.bintray.com/ekito/koin")
    }
}
