import DemoUtil.createPlot
import DemoUtil.openInBrowser
import org.jetbrains.letsPlot.awt.plot.PlotSvgExport
import org.jetbrains.letsPlot.intern.toSpec

fun main() {
    val p = createPlot()

    // ------------------------------------------------------------------
    // Note: To save plot to a SVG file just use the 'ggsave()' function.
    // ------------------------------------------------------------------

    val content = PlotSvgExport.buildSvgImageFromRawSpecs(p.toSpec())
    openInBrowser(content)
}