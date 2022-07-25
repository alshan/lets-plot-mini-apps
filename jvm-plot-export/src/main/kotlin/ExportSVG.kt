import DemoUtil.createPlot
import DemoUtil.openInBrowser
import jetbrains.datalore.plot.PlotSvgExport
import org.jetbrains.letsPlot.intern.toSpec

fun main() {
    val p = createPlot()

    // Export to SVG.
    // Note: if all you need is to save SVG to a file than you can just use the 'ggsave()' function.
    val content = PlotSvgExport.buildSvgImageFromRawSpecs(p.toSpec())
    openInBrowser(content)
}