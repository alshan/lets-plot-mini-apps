import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import java.util.*

plugins {
    kotlin("multiplatform") apply false
    kotlin("jvm") apply false
}

val localProps = Properties()
file("local.properties").takeIf { it.exists() }?.inputStream()?.use {
    localProps.load(it)
}

allprojects {
    repositories {
        mavenCentral()

        // Dev-SNAPSHOTS
        // Repositories where other projects publish their artifacts locally to.
        localProps["maven.repo.local"]?.let {
            (it as String).split(",").forEach { repo ->
                mavenLocal {
                    url = uri(repo)
                }
            }
        }

        // SNAPSHOTS
        maven(url = "https://central.sonatype.com/repository/maven-snapshots/")
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_1_8)
        }
    }

    tasks.withType<JavaCompile>().all {
        sourceCompatibility = "1.8"
        targetCompatibility = "1.8"
    }
}
