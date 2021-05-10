plugins {
    id("java-platform")
    id("maven-publish")
}

val room = "2.2.5"
val okhttp = "3.10.0"
val retrofit = "2.9.0"
val activity = "1.2.2"
val lifecycle = "2.3.1"
val core = "1.3.2"

val appcompat = "1.2.0"
val cardview = "1.0.0"
val archTesting = "2.0.0"
val benchmark = "1.0.0"
val browser = "1.0.0"
val constraintLayout = "2.0.4"
val coroutines = "1.3.4"
val coroutinesTest = "1.3.4"
val crashlytics = "2.9.8"
val drawerLayout = "1.1.0-rc01"
val espresso = "3.1.1"
val fragment = "1.2.4"
val glide = "4.9.0"
val gson = "2.8.6"
val hamcrest = "1.3"
val hilt = DependencyVersions.HILT

val hiltJetPack = "1.0.0-SNAPSHOT"
val junit = "4.13"
val junitExt = "1.1.1"
val lottie = "3.0.0"
val material = "1.3.0"
val mockito = "3.3.1"
val mockitoKotlin = "1.5.0"
val rules = "1.1.1"
val runner = "1.2.0"
val timber = "4.7.1"
val viewpager2 = "1.0.0"
val mpChart = "v3.1.0"

dependencies {
    constraints {
        api("${Dependencies.CONSTRAINT_LAYOUT}:$constraintLayout")
        api("${Dependencies.MATERIAL}:$material")
        api("${Dependencies.ACTIVITY_KTX}:${activity}")
        api("${Dependencies.CORE_KTX}:$core")
        api("${Dependencies.KOTLIN_STDLIB}:${DependencyVersions.KOTLIN}")

        api("${Dependencies.LIFECYCLE_COMPILER}:$lifecycle")
        api("${Dependencies.LIFECYCLE_LIVE_DATA_KTX}:$lifecycle")
        api("${Dependencies.LIFECYCLE_VIEW_MODEL_KTX}:$lifecycle")

        api("${Dependencies.HILT_ANDROID}:${DependencyVersions.HILT}")
        api("${Dependencies.HILT_VIEWMODEL}:${DependencyVersions.HILT_JETPACK}")
        api("${Dependencies.HILT_COMPILER}:${DependencyVersions.HILT}")
        api("${Dependencies.ANDROIDX_HILT_COMPILER}:${DependencyVersions.HILT_JETPACK}")
        api("${Dependencies.HILT_TESTING}:${DependencyVersions.HILT}")

        api("${Dependencies.ROOM_KTX}:$room")
        api("${Dependencies.ROOM_RUNTIME}:$room")
        api("${Dependencies.ROOM_COMPILER}:$room")

        api("${Dependencies.OKHTTP}:$okhttp")
        api("${Dependencies.OKHTTP_LOGGING_INTERCEPTOR}:$okhttp")
        api("${Dependencies.RETROFIT}:$retrofit")
        api("${Dependencies.RETROFIT_GSON}:$retrofit")

        api("${Dependencies.GSON}:$gson")

        api("${Dependencies.FRAGMENT_KTX}:$fragment")
        api("${Dependencies.NAVIGATION_FRAGMENT_KTX}:${DependencyVersions.NAVIGATION}")
        api("${Dependencies.NAVIGATION_UI_KTX}:${DependencyVersions.NAVIGATION}")

        api("${Dependencies.VIEWPAGER2}:$viewpager2")
        api("${Dependencies.CARDVIEW}:$cardview")

        api("${Dependencies.TIMBER}:$timber")
        api("${Dependencies.MP_CHART}:$mpChart")
        api("${Dependencies.GLIDE}:$glide")
        api("${Dependencies.GLIDE_COMPILER}:$glide")

        api("${Dependencies.CRASHLYTICS}:$crashlytics")
        api("${Dependencies.HAMCREST}:$hamcrest")

        api("${Dependencies.MOCKITO_CORE}:$mockito")
        api("${Dependencies.MOCKITO_KOTLIN}:$mockitoKotlin")
        api("${Dependencies.RULES}:$rules")
        api("${Dependencies.RUNNER}:$runner")
        api("${Dependencies.JUNIT}:$junit")
        api("${Dependencies.EXT_JUNIT}:$junitExt")
        api("${Dependencies.ESPRESSO_CORE}:$espresso")
        api("${Dependencies.ESPRESSO_CONTRIB}:$espresso")

        api("${Dependencies.ARCH_TESTING}:$archTesting")
        api("${Dependencies.BENCHMARK}:$benchmark")
        api("${Dependencies.COROUTINES_TEST}:$coroutines")
    }
}

publishing {
    publications {
        create<MavenPublication>("myPlatform") {
            from(components["javaPlatform"])
        }
    }
}