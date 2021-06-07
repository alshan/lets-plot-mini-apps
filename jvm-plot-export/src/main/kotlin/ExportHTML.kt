import DemoUtil.createPlot
import DemoUtil.openInBrowser
import jetbrains.datalore.plot.PlotHtmlExport
import jetbrains.datalore.plot.PlotHtmlHelper.scriptUrl
import jetbrains.letsPlot.intern.toSpec

fun main() {
    val p = createPlot()

    // Export to HTML.
    // Note: if all you need is to save HTML to a file than you can just use the 'ggsave()' function.
    val content = PlotHtmlExport.buildHtmlFromRawSpecs(p.toSpec(), scriptUrl("2.0.3"))
    openInBrowser(content)
}