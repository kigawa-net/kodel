plugins {
    id("net.kigawa.kutil.kutil.java-conventions")
    id("net.kigawa.kodel.maven-publish-conventions")
    kotlin("plugin.serialization")
}

dependencies {
}

publishing {
    publications {
        withType<MavenPublication> {
            pom {
                name.set("kutil")
                description.set("utilities for kotlin")
            }
        }
    }
}
