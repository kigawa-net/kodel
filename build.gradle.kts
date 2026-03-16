plugins {
    kotlin("multiplatform")
    id("io.github.gradle-nexus.publish-plugin")
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
    jvm {}
}

nexusPublishing {
    repositories {
        sonatype {
            nexusUrl.set(uri("https://ossrh-staging-api.central.sonatype.com/service/local/"))
            snapshotRepositoryUrl.set(uri("https://central.sonatype.com/repository/maven-snapshots/"))
            username.set(providers.environmentVariable("MAVEN_USERNAME"))
            password.set(providers.environmentVariable("MAVEN_PASSWORD"))
        }
    }
}
