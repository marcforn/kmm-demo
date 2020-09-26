buildscript {
    repositories {
        gradlePluginPortal()
        jcenter()
        google()
        mavenCentral()
    }

    val GRADLE_VERSION: String by project
    val KOTLIN_VERSION: String by project

    dependencies {
        classpath("com.android.tools.build:gradle:$GRADLE_VERSION")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$KOTLIN_VERSION")
        classpath("org.jetbrains.kotlin:kotlin-serialization:$KOTLIN_VERSION")
    }
}

group = "com.mforn.kmmdemo"
version = "1.0-SNAPSHOT"

allprojects {
    repositories {
        mavenCentral()
        maven(url = "https://dl.bintray.com/ekito/koin")
    }
}
