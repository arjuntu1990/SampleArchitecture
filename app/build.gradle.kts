plugins {
    id("com.android.application")
    id("kotlin-android")
    kotlin("android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdkVersion(30)
    buildToolsVersion("30.0.3")

    defaultConfig {
        applicationId = "com.arjuntu90.samplearchitecture"
        minSdkVersion(23)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        getByName("debug") {
            versionNameSuffix = "-debug"
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
        dataBinding = true
    }
}

dependencies {
    /*implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("com.google.android.material:material:1.3.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    testImplementation("junit:junit:4.+")
    androidTestImplementation("androidx.test.ext:junit:1.1.2")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.3.0")*/

    implementation(Dependencies.KOTLIN_STDLIB)
    implementation(Dependencies.CORE_KTX)

    api(platform(project(":depprovider")))
    kapt(platform(project(":depprovider")))
    implementation(project(":logic"))
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))


    // UI
    implementation(Dependencies.ACTIVITY_KTX)
    implementation(Dependencies.APPCOMPAT)
    implementation(Dependencies.FRAGMENT_KTX)
    implementation(Dependencies.CARDVIEW)
    implementation(Dependencies.CONSTRAINT_LAYOUT)
    implementation(Dependencies.MATERIAL)

    // Architecture Components
    implementation(Dependencies.LIFECYCLE_LIVE_DATA_KTX)
    kapt(Dependencies.LIFECYCLE_COMPILER)
    testImplementation(Dependencies.ARCH_TESTING)
    implementation(Dependencies.NAVIGATION_FRAGMENT_KTX)
    implementation(Dependencies.NAVIGATION_UI_KTX)
    implementation(Dependencies.ROOM_KTX)
    implementation(Dependencies.ROOM_RUNTIME)
    kapt(Dependencies.ROOM_COMPILER)
    testImplementation(Dependencies.ROOM_KTX)
    testImplementation(Dependencies.ROOM_RUNTIME)

    // Dagger Hilt
    implementation(Dependencies.HILT_ANDROID)
    implementation(Dependencies.HILT_VIEWMODEL)
    androidTestImplementation(Dependencies.HILT_TESTING)
    kapt(Dependencies.HILT_COMPILER)
    kapt(Dependencies.ANDROIDX_HILT_COMPILER)
    kaptAndroidTest(Dependencies.HILT_COMPILER)
    kaptAndroidTest(Dependencies.ANDROIDX_HILT_COMPILER)

    // OkHttp
    implementation(Dependencies.OKHTTP)
    implementation(Dependencies.OKHTTP_LOGGING_INTERCEPTOR)

    // retrofit
    implementation(Dependencies.RETROFIT)
    implementation(Dependencies.RETROFIT_GSON)

    // Glide
    implementation(Dependencies.GLIDE)
    kapt(Dependencies.GLIDE_COMPILER)


    implementation(Dependencies.MP_CHART)

    // Kotlin
    implementation(Dependencies.KOTLIN_STDLIB)

    // Instrumentation tests
    androidTestImplementation(Dependencies.ESPRESSO_CORE)
    androidTestImplementation(Dependencies.ESPRESSO_CONTRIB)
    androidTestImplementation(Dependencies.EXT_JUNIT)
    androidTestImplementation(Dependencies.RUNNER)
    androidTestImplementation(Dependencies.RULES)

    // Local unit tests
    testImplementation(Dependencies.JUNIT)
    testImplementation(Dependencies.MOCKITO_CORE)
    testImplementation(Dependencies.MOCKITO_KOTLIN)
    testImplementation(Dependencies.HAMCREST)

    // Solve conflicts with gson. DataBinding is using an old version.
    implementation(Dependencies.GSON)
}