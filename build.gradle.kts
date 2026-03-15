plugins {
    kotlin("multiplatform")
}
allprojects {
    apply(plugin = "org.jetbrains.kotlin.multiplatform")
    version = "dev"
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