# Lets-Plot Mini Apps (Demos)

This repository contains examples of using the [Lets-Plot Kotlin API](https://github.com/JetBrains/lets-plot-kotlin) 
in JVM and Kotlin/JS projects.

- #### [jvm-swing-batik-app](https://github.com/alshan/lets-plot-mini-apps/blob/main/jvm-swing-batik-app/src/main/kotlin/Main.kt):
  A JVM/Swing app which uses Apache Batik for plot rendering.
  
- #### [jvm-swing-javafx-app](https://github.com/alshan/lets-plot-mini-apps/blob/main/jvm-swing-javafx-app/src/main/kotlin/Main.kt):
  A JVM/Swing app which renders plot to JavaFX Scene inside `javafx.embed.swing.JFXPanel`.
  
- #### [jvm-javafx-app](https://github.com/alshan/lets-plot-mini-apps/tree/main/jvm-javafx-app):
  A JavaFX app which renders plot to JavaFX Scene inside `javafx.embed.swing.JFXPanel`.

  The Swing panel with plot in then embedded into a JavaFX application via `javafx.embed.swing.SwingNode`.
    
- #### [js-frontend-app](https://github.com/alshan/lets-plot-mini-apps/tree/main/js-frontend-app):
  A Kotlin/JS app (Kotlin LEGACY compiler). 
                                                         
- #### [js-ir-frontend-app](https://github.com/alshan/lets-plot-mini-apps/tree/main/js-ir-frontend-app):
  A Kotlin/JS IR app (Kotlin IR compiler). 
                                                         
- #### [jvm-plot-export](https://github.com/alshan/lets-plot-mini-apps/tree/main/jvm-plot-export/src/main/kotlin):
  Using `PlotSvgExport` and `PlotHtmlExport` utilities for exporting of a plot to a string in SVG and HTML formats.