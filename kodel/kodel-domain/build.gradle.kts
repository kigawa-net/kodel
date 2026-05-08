@file:OptIn(ExperimentalWasmDsl::class)

import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.targets.js.testing.KotlinJsTest

plugins {
    kotlin("multiplatform")
    id("net.kigawa.kodel.maven-publish-conventions")
}

repositories {
    mavenCentral()
    gradlePluginPortal()
}
fun KotlinJsTest.browserTest() {
    val firefox = providers.gradleProperty("useFirefox")
        .map { it.toBoolean() }
        .getOrElse(true)
    val chrome = providers.gradleProperty("useChrome")
        .map { it.toBoolean() }
        .getOrElse(true)
    enabled = firefox || chrome
    useKarma {
        if (firefox) useFirefoxHeadless()
        if (chrome) useChromeHeadlessNoSandbox()
    }
}
kotlin {
    jvmToolchain(25)

    compilerOptions {
        freeCompilerArgs = listOf("-Xcontext-parameters")
    }
    jvm {}
    js {
        browser {
            testTask {
                browserTest()
            }
        }
    }
    wasmJs {
        browser {
            testTask {
                enabled
                browserTest()
            }
        }
    }

    // iOS targets for mobile support
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { _ ->
    }
    sourceSets {
        commonMain {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.7.1-0.6.x-compat")
            }
        }
        commonTest {
            dependencies {
                implementation(kotlin("test"))
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.11.0")
            }
        }
    }
}

publishing {
    publications {
        withType<MavenPublication> {
            pom {
                name.set("Kodel Domain")
                description.set("Domain model for Kodel")
            }
        }
    }
}
