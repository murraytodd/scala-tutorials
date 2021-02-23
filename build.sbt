import Dependencies._

ThisBuild / version := "0.0.1-SNAPSHOT"
ThisBuild / organization := "com.murraywilliams"
ThisBuild / scalaVersion := "2.13.5"

lazy val commonDependencies = Seq( catsCore, scalaTest % Test )

lazy val commonSettings = Seq(
	scalacOptions ++= Seq("-feature")
)

lazy val monoids = project
	.settings(
		commonSettings,
		libraryDependencies ++= commonDependencies
	)

lazy val implicits = project
	.settings(
		commonSettings,
		libraryDependencies ++= commonDependencies
	)

lazy val monads = project
	.settings(
		commonSettings,
		libraryDependencies ++= commonDependencies
	)

// scalac options come from the sbt-tpolecat plugin so need to set any here

//addCompilerPlugin("org.typelevel" %% "kind-projector" % "0.11.0" cross CrossVersion.full)
