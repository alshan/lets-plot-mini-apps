import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    kotlin("multiplatform") apply false
    kotlin("jvm") apply false
}

allprojects {
    repositories {
        mavenCentral()

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
