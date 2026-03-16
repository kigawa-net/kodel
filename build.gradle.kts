plugins {
    kotlin("multiplatform")
}
allprojects {
    apply(plugin = "org.jetbrains.kotlin.multiplatform")
    version = findProperty("releaseVersion")?.toString() ?: "dev"
    group = "net.kigawa.kodel"
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
    kotlin {
    }
}
kotlin {
    jvm{}
}