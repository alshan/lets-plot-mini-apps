plugins {
    kotlin("multiplatform") apply false
    kotlin("jvm") apply false
}

allprojects {
    repositories {
        mavenCentral()

        // SNAPSHOTS
        maven(url = "https://oss.sonatype.org/content/repositories/snapshots")
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().all {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }

    tasks.withType<JavaCompile>().all {
        sourceCompatibility = "1.8"
        targetCompatibility = "1.8"
    }
}
