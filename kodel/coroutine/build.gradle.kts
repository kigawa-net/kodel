@file:OptIn(ExperimentalWasmDsl::class)

import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins {
    kotlin("multiplatform")
    id("net.kigawa.kodel.maven-publish-conventions")
}

repositories {
    mavenCentral()
    gradlePluginPortal()
}

kotlin {
    compilerOptions {
        freeCompilerArgs = listOf("-Xcontext-parameters")
    }
    jvm {}
    js {
        browser()
    }
    wasmJs {
        browser()
    }

    // iOS targets for mobile support
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "KodelCoroutine"
            isStatic = true
        }
    }
    sourceSets {
        commonMain {
            dependencies {
                api(project(":kodel:kodel-domain"))
                api("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.11.0")
            }
        }
        commonTest {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}

publishing {
    publications {
        withType<MavenPublication> {
            pom {
                name.set("Kodel Coroutine")
                description.set("Coroutine utilities for Kodel")
            }
        }
    }
}
