import org.jetbrains.letsPlot.geom.geomDensity
import org.jetbrains.letsPlot.intern.Plot
import org.jetbrains.letsPlot.letsPlot
import java.awt.Desktop
import java.io.File

object DemoUtil {
    fun createPlot(): Plot {
        val rand = java.util.Random()
        val n = 200
        val data = mapOf<String, Any>(
            "x" to List(n) { rand.nextGaussian() }
        )

        return letsPlot(data) + geomDensity(
            color = "dark-green",
            fill = "green",
            alpha = .3,
            size = 2.0
        ) { x = "x" }
    }

    fun openInBrowser(content: String) {
        val dir = File(System.getProperty("user.dir"), "lets-plot-images")
        dir.mkdir()
        val file = File(dir.canonicalPath, "my_plot.html")
        file.createNewFile()
        file.writeText(content)

        Desktop.getDesktop().browse(file.toURI())
    }
}