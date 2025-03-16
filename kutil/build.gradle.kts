import java.net.URI

plugins {
  `maven-publish`
  signing
  id("net.kigawa.kutil.kutil.java-conventions")
  id("org.jetbrains.dokka") version "1.9.20"
}

dependencies {
}


publishing {

  publications {
    withType<MavenPublication> {
//      artifactId = if (name == "kotlinMultiplatform") artifactId
//      else "$artifactId-$name"

      pom {
        name.set("kutil")
        description.set("utilities for kotlin")
        url.set("https://github.com/kigawa01/kutil/")
        properties.set(
          mapOf(
          )
        )
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

        // Each archive name should be distinct, to avoid implicit dependency issues.
        // We use the same format as the sources Jar tasks.
        // https://youtrack.jetbrains.com/issue/KT-46466
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