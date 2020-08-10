name := "monoids"
version := "0.0.1-SNAPSHOT"
organization := "com.murraywilliams"

scalaVersion := "2.13.2"

libraryDependencies += "org.typelevel" %% "cats-core" % "2.1.0"

// scalac options come from the sbt-tpolecat plugin so need to set any here

addCompilerPlugin("org.typelevel" %% "kind-projector" % "0.11.0" cross CrossVersion.full)
