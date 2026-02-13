import DemoUtil.createPlot
import DemoUtil.openInBrowser
import org.jetbrains.letsPlot.core.util.PlotSvgExport
import org.jetbrains.letsPlot.intern.toSpec

fun main() {
    val p = createPlot()

    // ------------------------------------------------------------------
    // Note: To save plot to an SVG file, just use the 'ggsave()' function.
    // ------------------------------------------------------------------

    val content = PlotSvgExport.buildSvgImageFromRawSpecs(p.toSpec())
    openInBrowser(content)
}