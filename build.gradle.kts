// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
        jcenter()
        // Hilt Jetpack integrations
        maven { url = uri("https://androidx.dev/snapshots/builds/6515566/artifacts/repository") }
    }
    dependencies {
        classpath("com.android.tools.build:gradle:4.1.3")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${DependencyVersions.KOTLIN}")
        classpath("com.google.dagger:hilt-android-gradle-plugin:${DependencyVersions.HILT}")
        classpath("androidx.benchmark:benchmark-gradle-plugin:${DependencyVersions.BENCHMARK}")

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle.kts.kts files
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        jcenter()
        // Hilt Jetpack integrations
        maven { url = uri("https://androidx.dev/snapshots/builds/6515566/artifacts/repository") }
        maven { url = uri("https://jitpack.io") }

        flatDir {
            dirs = setOf(file("libs"))
        }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}