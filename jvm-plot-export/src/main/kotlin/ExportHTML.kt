import DemoUtil.createPlot
import DemoUtil.openInBrowser
import org.jetbrains.letsPlot.core.util.PlotHtmlExport
import org.jetbrains.letsPlot.core.util.PlotHtmlHelper.scriptUrl
import org.jetbrains.letsPlot.export.VersionChecker
import org.jetbrains.letsPlot.intern.toSpec

fun main() {
    val p = createPlot()

    // ------------------------------------------------------------------
    // Note: To save plot to an HTML file just use the 'ggsave()' function.
    // ------------------------------------------------------------------

    val content = PlotHtmlExport.buildHtmlFromRawSpecs(p.toSpec(), scriptUrl(VersionChecker.letsPlotJsVersion))
    openInBrowser(content)
}