import DemoUtil.createPlot
import DemoUtil.openInBrowser
import org.jetbrains.letsPlot.awt.plot.PlotSvgExport
import org.jetbrains.letsPlot.commons.encoding.Base64
import org.jetbrains.letsPlot.core.plot.export.PlotImageExport
import org.jetbrains.letsPlot.intern.toSpec

fun main() {
    val p = createPlot()

    // ------------------------------------------------------------------
    // Note: To save plot to a PNG file just use the 'ggsave()' function.
    // ------------------------------------------------------------------

    val image = PlotImageExport.buildImageFromRawSpecs(
        plotSpec = p.toSpec(),
        format = PlotImageExport.Format.PNG,
        scalingFactor = 2.0,
        targetDPI = Double.NaN
    )

    val base64EncodedPng = Base64.encode(image.bytes)
    val dataUrl = "data:image/png;base64,$base64EncodedPng"
    val content = """
        <html>
           <img src="$dataUrl" alt="plot image" width="${image.plotSize.x}" height="${image.plotSize.y}">
        </html>
    """.trimIndent()

    openInBrowser(content)
}