@file:OptIn(ExperimentalWasmDsl::class)

import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import java.net.URI

plugins {
    kotlin("multiplatform")
    `maven-publish`
    signing
    id("org.jetbrains.dokka") version "1.9.20"
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
    js{
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
                api(project(":kodel:api"))
                api("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.2")
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
                url.set("https://github.com/kigawa01/kutil/")
                licenses {
                    license {
                        name.set("MIT License")
                        url.set("http://www.opensource.org/licenses/mit-license.php")
                    }
                }
                developers {
                    developer {
                        id.set("net.kigawa")
                        name.set("kigawa")
                        email.set("contact@kigawa.net")
                    }
                }
                scm {
                    connection.set("scm:git:https://github.com/kigawa01/kutil-java.git")
                    developerConnection.set("scm:git:https://github.com/kigawa01/kutil-java.git")
                    url.set("https://github.com/kigawa01/kutil-java")
                }
            }
            val dokkaJar = project.tasks.register("${this.name}DokkaJar", Jar::class) {
                group = JavaBasePlugin.DOCUMENTATION_GROUP
                description = "Assembles Kotlin docs with Dokka into a Javadoc jar"
                archiveClassifier.set("javadoc")
                from(tasks.named("dokkaHtml"))
                archiveBaseName.set("${archiveBaseName.get()}-${this.name}")
            }
            artifact(dokkaJar)
        }
    }

    repositories {
        maven {
            name = "OSSRH"
            url = URI("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")
            credentials {
                username = System.getenv("MAVEN_USERNAME")
                password = System.getenv("MAVEN_PASSWORD")
            }
        }
    }
}
signing {
    sign(publishing.publications)
}
