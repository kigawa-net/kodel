import java.net.URI

plugins {
    `maven-publish`
    signing
    id("org.jetbrains.dokka")
}

val isJitPack = System.getenv("JITPACK") != null

tasks.matching { it.name.startsWith("dokka") }.configureEach {
    enabled = !isJitPack
}

publishing {
    publications {
        withType<MavenPublication> {
            val dokkaJar = project.tasks.register("${this.name}DokkaJar", Jar::class) {
                group = JavaBasePlugin.DOCUMENTATION_GROUP
                description = "Assembles Kotlin docs with Dokka into a Javadoc jar"
                archiveClassifier.set("javadoc")
                from(tasks.named("dokkaGeneratePublicationHtml"))
                archiveBaseName.set("${archiveBaseName.get()}-${this.name}")
            }
            artifact(dokkaJar)

            pom {
                url.set("https://github.com/kigawa01/kodel/")
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
                    connection.set("scm:git:https://github.com/kigawa01/kodel.git")
                    developerConnection.set("scm:git:https://github.com/kigawa01/kodel.git")
                    url.set("https://github.com/kigawa01/kodel")
                }
            }
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
    val signingKey = System.getenv("SIGNING_KEY")
    val signingPassword = System.getenv("SIGNING_PASSWORD")
    if (!isJitPack && signingKey != null) {
        useInMemoryPgpKeys(signingKey, signingPassword)
        sign(publishing.publications)
    }
}
