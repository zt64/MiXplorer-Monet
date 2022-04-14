val composeVersion = "1.2.0-alpha07"
val accompanistVersion = "0.24.6-alpha"

plugins {
    id("com.android.application")
    id("kotlin-android")
    kotlin("plugin.serialization") version "1.6.10"
}

android {
    compileSdk = 31

    defaultConfig {
        applicationId = "com.zt64.mixplorermonet"
        minSdk = 31
        targetSdk = 31
        versionCode = 1
        versionName = "0.0.1"

        vectorDrawables.useSupportLibrary = true
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
        freeCompilerArgs = freeCompilerArgs + "-Xopt-in=kotlin.RequiresOptIn"
    }

    buildFeatures.compose = true
    composeOptions.kotlinCompilerExtensionVersion = composeVersion
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.4.1")
    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.core:core-splashscreen:1.0.0-beta02")
    implementation("androidx.activity:activity-compose:1.4.0")

    implementation("androidx.compose.ui:ui:${composeVersion}")
    implementation("androidx.compose.ui:ui-tooling:${composeVersion}")
    implementation("androidx.compose.material:material-icons-extended:${composeVersion}")
    implementation("androidx.compose.material3:material3:1.0.0-alpha09")

    implementation("com.google.accompanist:accompanist-systemuicontroller:$accompanistVersion")
}