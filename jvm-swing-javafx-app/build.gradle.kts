import org.gradle.nativeplatform.platform.internal.DefaultNativePlatform

plugins {
    kotlin("jvm")
}

val letsPlotVersion = extra["letsPlot.version"] as String
val letsPlotKotlinVersion = extra["letsPlotKotlin.version"] as String
val slf4jVersion = extra["slf4j.version"] as String

val jfxVersion = extra["jfx.version"] as String
val currentOS = DefaultNativePlatform.getCurrentOperatingSystem()!!
val jfxPlatform = when {
    currentOS.isWindows -> "win"
    currentOS.isLinux -> "linux"
    currentOS.isMacOsX -> "mac"
    else -> throw IllegalStateException("Unexpected OS: ${currentOS.name}")
}

dependencies {
    implementation("org.jetbrains.lets-plot:lets-plot-jfx:$letsPlotVersion")
    implementation("org.jetbrains.lets-plot:lets-plot-kotlin-jvm:$letsPlotKotlinVersion")

    implementation("org.openjfx:javafx-base:$jfxVersion:$jfxPlatform")
    implementation("org.openjfx:javafx-swing:$jfxVersion:$jfxPlatform")
    implementation("org.openjfx:javafx-graphics:$jfxVersion:$jfxPlatform")

    implementation("org.slf4j:slf4j-simple:$slf4jVersion")  // Enable logging to console
}
