ThisBuild / scalaVersion := "2.12.7"
ThisBuild / organization := "com.example"

val scalaTest = "org.scalatest" %% "scalatest" % "3.0.5"
val gigahorse = "com.eed3si9n" %% "gigahorse-okhttp" % "0.3.1"
val playJson  = "com.typesafe.play" %% "play-json" % "2.6.9"

lazy val weatherApp = (project in file("."))
  .aggregate(weatherAppCore)
  .dependsOn(weatherAppCore)
  .enablePlugins(JavaAppPackaging)
  .settings(
    name := "Weather App",
    libraryDependencies += scalaTest % Test,
  )

lazy val weatherAppCore = (project in file("core"))
  .settings(
    name := "Weather App Core",
    libraryDependencies ++= Seq(gigahorse, playJson),
    libraryDependencies += scalaTest % Test,
  )

