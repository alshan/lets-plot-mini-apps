# lets-plot-mini-apps

This repository contains examples of using the [Lets-Plot Kotlin API](https://github.com/JetBrains/lets-plot-kotlin) 
in JVM and Kotlin/JS projects.

- [jvm-swing-batik-app](https://github.com/alshan/lets-plot-mini-apps/tree/main/jvm-swing-batik-app/src/main/kotlin):
  a JVM app which uses Apache Batik for rendering.
  
- [jvm-swing-javafx-app](https://github.com/alshan/lets-plot-mini-apps/tree/main/jvm-swing-javafx-app/src/main/kotlin):
  a JVM app which renders plot to JavaFX Scene. Note: additional JavaFX dependencies needed in case JFX is not included in your JRE.
  
- [js-frontend-app](https://github.com/alshan/lets-plot-mini-apps/tree/main/js-frontend-app):
  a Kotlin/JS app (Kotlin LEGACY compiler). 
  
  You can run this app using Gradle command:
```
./gradlew :js-frontend-app:browserDevelopmentRun
```
                                                         
- [js-ir-frontend-app](https://github.com/alshan/lets-plot-mini-apps/tree/main/js-ir-frontend-app):
  a Kotlin/JS IR app (Kotlin IR compiler). 
  
  You can run this app using Gradle command:
```
./gradlew :js-ir-frontend-app:browserDevelopmentRun
```
                                                         
- [jvm-plot-export](https://github.com/alshan/lets-plot-mini-apps/tree/main/jvm-plot-export/src/main/kotlin):
  Using `PlotSvgExport` and `PlotHtmlExport` utilities for exporting of a plot to a string in SVG and HTML formats.