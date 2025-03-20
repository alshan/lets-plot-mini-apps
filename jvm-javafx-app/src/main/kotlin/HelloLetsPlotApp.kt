import javafx.application.Application
import javafx.application.Platform
import javafx.embed.swing.SwingNode
import javafx.scene.Scene
import javafx.scene.layout.StackPane
import javafx.stage.Stage
import org.jetbrains.letsPlot.core.util.MonolithicCommon
import org.jetbrains.letsPlot.geom.geomDensity
import org.jetbrains.letsPlot.intern.toSpec
import org.jetbrains.letsPlot.jfx.plot.component.DefaultPlotPanelJfx
import org.jetbrains.letsPlot.letsPlot
import javax.swing.JPanel
import javax.swing.SwingUtilities

class HelloLetsPlotApp : Application() {
    override fun start(primaryStage: Stage) {
        // Make sure JavaFX event thread won't get killed after JFXPanel is destroyed.
        Platform.setImplicitExit(false)

        primaryStage.title = "Lets-Plot in JavaFX Application Demo"

        val root = StackPane()
        val swingNode = SwingNode()

        // Create plot panel in Swing thread
        SwingUtilities.invokeLater {
            val plotSwingPanel = createPlotPanel()
            swingNode.content = plotSwingPanel
        }

        root.children.add(swingNode)
        primaryStage.scene = Scene(root, 500.0, 300.0)
        primaryStage.show()
    }

    companion object {
        fun createPlotPanel(): JPanel {
            // Density plot
            val rand = java.util.Random()
            val n = 200
            val data = mapOf<String, Any>(
                "x" to List(n) { rand.nextGaussian() }
            )

            val plot = letsPlot(data) + geomDensity(
                color = "dark-green",
                fill = "green",
                alpha = .3,
                size = 2.0
            ) { x = "x" }

            val rawSpec = plot.toSpec()
            val processedSpec = MonolithicCommon.processRawSpecs(rawSpec, frontendOnly = false)

            return DefaultPlotPanelJfx(
                processedSpec = processedSpec,
                preserveAspectRatio = false,
                preferredSizeFromPlot = false,
                repaintDelay = 10,
            ) { messages ->
                for (message in messages) {
                    println("[Example App] $message")
                }
            }
        }
    }
}