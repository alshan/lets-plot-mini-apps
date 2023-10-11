plugins {
    kotlin("multiplatform")
}

kotlin {
    js {
        browser()
        binaries.executable()
    }

// Make sure the correct version of Lets-Plot JS is set in ./resources/index.html
//    val letsPlotVersion = extra["letsPlot.version"] as String

    val letsPlotKotlinVersion = extra["letsPlotKotlin.version"] as String

    sourceSets {
        named("jsMain") {
            dependencies {
                implementation("org.jetbrains.lets-plot:lets-plot-kotlin-js:$letsPlotKotlinVersion")
            }
        }
    }
}
