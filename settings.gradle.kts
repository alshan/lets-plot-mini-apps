pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        google()
    }

    plugins {
        val kotlinVersion = extra["kotlin.version"] as String
        val jfxPluginVersion = extra["jfxPlugin.version"] as String

        kotlin("multiplatform") version kotlinVersion
        kotlin("jvm") version kotlinVersion

        id("org.openjfx.javafxplugin") version jfxPluginVersion
    }
}

include("js-frontend-app")
include("jvm-swing-batik-app")
include("jvm-swing-javafx-app")
include("jvm-javafx-app")
include("jvm-plot-export")
