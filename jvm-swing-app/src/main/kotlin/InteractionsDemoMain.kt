/*
 * Copyright (c) 2026. JetBrains s.r.o.
 * Use of this source code is governed by the MIT license that can be found in the LICENSE file.
 */

import org.jetbrains.letsPlot.awt.plot.swing.SwingPlotPanel
import org.jetbrains.letsPlot.awt.sandbox.SandboxToolbarAwt
import org.jetbrains.letsPlot.core.interact.InteractionSpec
import org.jetbrains.letsPlot.core.plot.builder.interact.tools.WithFigureModel
import org.jetbrains.letsPlot.core.util.MonolithicCommon
import org.jetbrains.letsPlot.geom.geomDensity
import org.jetbrains.letsPlot.interact.ggtb
import org.jetbrains.letsPlot.intern.toSpec
import org.jetbrains.letsPlot.letsPlot
import java.awt.BorderLayout
import java.util.*
import javax.swing.JComponent
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.SwingUtilities

fun main() {
    val rand = Random()
    val n = 200
    val data = mapOf<String, Any>(
        "x" to List(n) { rand.nextGaussian() }
    )

    val densityPlot = letsPlot(data) + geomDensity(
        color = "dark-green",
        fill = "green",
        alpha = .3,
        size = 2.0
    ) {
        x = "x"
    } + ggtb() // Show a built-in toolbar.

    SwingUtilities.invokeLater {
        createAndShowGui(
            rawSpec = densityPlot.toSpec()
        )
    }
}

private fun createAndShowGui(rawSpec: MutableMap<String, Any>) {
    val frame = JFrame("Toolbar and Default Interactions").apply {
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        layout = BorderLayout()
    }

    // Custom toolbar
    val toolbar = SandboxToolbarAwt()
    frame.add(toolbar, BorderLayout.NORTH)

    // Plot panel
    val plotPanel = createPlotPanel(rawSpec)
    val figureModel = (plotPanel as WithFigureModel).figureModel
    toolbar.attach(figureModel)

    // Setup plot default interactions
    val defaultInteractions = listOf(
        InteractionSpec(
            InteractionSpec.Name.WHEEL_ZOOM,
            keyModifiers = listOf(
                InteractionSpec.KeyModifier.CTRL,
                InteractionSpec.KeyModifier.SHIFT
            )
        ),
        InteractionSpec(
            InteractionSpec.Name.DRAG_PAN,
            keyModifiers = listOf(
                InteractionSpec.KeyModifier.CTRL,
                InteractionSpec.KeyModifier.SHIFT
            )
        )
    )

    figureModel.setDefaultInteractions(defaultInteractions)

    frame.add(plotPanel, BorderLayout.CENTER)

    // Instructions
    frame.add(
        JLabel("Default interactions (no tool selected): Ctrl+Shift+Wheel to zoom, Ctrl+Shift+Drag to pan"),
        BorderLayout.SOUTH
    )

    frame.apply {
//        setSize(400, 400)
        pack()
        setLocationRelativeTo(null) // Center on screen
        isVisible = true
    }
}

private fun createPlotPanel(rawSpec: MutableMap<String, Any>): JComponent {
    val processedSpec = MonolithicCommon.processRawSpecs(rawSpec)
    return SwingPlotPanel(
        processedSpec = processedSpec,
        preserveAspectRatio = false,
        preferredSizeFromPlot = true,
        repaintDelay = 300,
        computationMessagesHandler = { messages -> messages.forEach { println("[!] $it") } }
    )
}
