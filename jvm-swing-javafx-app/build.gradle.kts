plugins {
    kotlin("jvm")
    id( "org.openjfx.javafxplugin")
}

javafx {
    version = extra["jfx.version"] as String
    modules = listOf("javafx.controls", "javafx.swing")
}

val letsPlotVersion = extra["letsPlot.version"] as String
val letsPlotKotlinVersion = extra["letsPlotKotlin.version"] as String
val slf4jVersion = extra["slf4j.version"] as String

dependencies {
    implementation("org.jetbrains.lets-plot:lets-plot-kotlin-jvm:$letsPlotKotlinVersion")
    implementation("org.jetbrains.lets-plot:lets-plot-jfx:$letsPlotVersion")

    implementation("org.slf4j:slf4j-simple:$slf4jVersion")  // Enable logging to console
}
