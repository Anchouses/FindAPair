plugins {
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.silaeva.findapair"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.silaeva.findapair"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(project(":menu-api"))
    implementation(project(":game-api"))
    implementation(project(":end-api"))

    implementation(libs.android.core)
    implementation(libs.android.appcompat)
    implementation(libs.android.material)
    implementation(libs.android.activity)

    implementation(libs.cicerone)

    implementation (libs.androidx.room.runtime)
    implementation (libs.androidx.room.ktx)
    annotationProcessor (libs.androidx.room.compiler)
    kapt (libs.androidx.room.compiler)

    implementation(libs.hilt)
    implementation(project(":menu-impl"))
    implementation(project(":game-impl"))
    implementation(project(":end-impl"))
    implementation(project(":data-impl"))
    kapt(libs.hilt.compiler)

    testImplementation(libs.test.junit)
    androidTestImplementation(libs.test.junit.android)
    androidTestImplementation(libs.test.espresso)
}

kapt {
    correctErrorTypes = true
}