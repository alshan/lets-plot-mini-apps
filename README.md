# lets-plot-mini-apps

This repository contains examples of using the [Lets-Plot Kotlin API](https://github.com/JetBrains/lets-plot-kotlin) 
in JVM and Kotlin-JS projects.

- [jvm-swing-batik-app](https://github.com/alshan/lets-plot-mini-apps/tree/main/jvm-swing-batik-app/src/main/kotlin):
  a JVM app which uses Apache Batik for rendering.
  
- [jvm-swing-javafx-app](https://github.com/alshan/lets-plot-mini-apps/tree/main/jvm-swing-javafx-app/src/main/kotlin):
  a JVM app which renders plot to JavaFX Scene. Note: additional JavaFX dependencies needed in case JFX is not included in your JRE.
  
- [js-frontend-app](https://github.com/alshan/lets-plot-mini-apps/tree/main/js-frontend-app):
  a Kotlin-JS app. 
  
  You can run this app using Gradle command:
```
./gradlew :js-frontend-app:browserDevelopmentRun
```
