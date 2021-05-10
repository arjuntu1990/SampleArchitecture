plugins {
    id("com.android.library")
    id("kotlin-android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdkVersion(30)
    buildToolsVersion("30.0.3")

    defaultConfig {
        minSdkVersion(23)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            buildConfigField("String", "BASE_URL", "\"https://www.7timer.info/\"")
        }
        getByName("debug") {
            buildConfigField("String", "BASE_URL", "\"https://www.7timer.info/\"")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(Dependencies.KOTLIN_STDLIB)
    implementation(Dependencies.CORE_KTX)

    implementation(Dependencies.LIFECYCLE_LIVE_DATA_KTX)
    implementation(Dependencies.LIFECYCLE_VIEW_MODEL_KTX)

    api(platform(project(":depprovider")))
    kapt(platform(project(":depprovider")))
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    // AppCompat
    implementation(Dependencies.APPCOMPAT)

    // Architecture Components
    implementation(Dependencies.LIFECYCLE_LIVE_DATA_KTX)
    implementation(Dependencies.LIFECYCLE_VIEW_MODEL_KTX)
    implementation(Dependencies.ROOM_KTX)
    implementation(Dependencies.ROOM_RUNTIME)
    kapt(Dependencies.ROOM_COMPILER)
    testImplementation(Dependencies.ARCH_TESTING)

    // Navigation
    implementation(Dependencies.NAVIGATION_FRAGMENT_KTX)
    implementation(Dependencies.NAVIGATION_UI_KTX)


    // Utils
    api(Dependencies.TIMBER)
    implementation(Dependencies.GSON)
    implementation(Dependencies.CORE_KTX)

    // OkHttp
    implementation(Dependencies.OKHTTP)
    implementation(Dependencies.OKHTTP_LOGGING_INTERCEPTOR)

    // retrofit
    implementation(Dependencies.RETROFIT)
    implementation(Dependencies.RETROFIT_GSON)

    // Kotlin
    implementation(Dependencies.KOTLIN_STDLIB)

    // Coroutines
    api(Dependencies.COROUTINES)
    testImplementation(Dependencies.COROUTINES_TEST)

    // Dagger Hilt
    implementation(Dependencies.HILT_ANDROID)
    kapt(Dependencies.HILT_COMPILER)


    // Has to be replaced to avoid compile / runtime conflicts between okhttp and firestore
    // api(Dependencies.OKIO)

    // ThreeTenBP for the shared module only. Date and time API for Java.
    /*testImplementation(Dependencies.THREETENBP)
    compileOnly("org.threeten:threetenbp:${Versions.THREETENBP}:no-tzdb")*/

    // Unit tests
    testImplementation(Dependencies.JUNIT)
    testImplementation(Dependencies.HAMCREST)
    testImplementation(Dependencies.MOCKITO_CORE)
    testImplementation(Dependencies.MOCKITO_KOTLIN)

    // unit tests livedata
    testImplementation(Dependencies.ARCH_TESTING)
}