name := "timeywimey-core"

organization := "com.meetup"

version := "0.1.0"

description := "Converters between JodaTime and Java 8 time classes, plus some legacy java.util time classes utility."

publishMavenStyle := true

crossPaths := false

autoScalaLibrary := false

libraryDependencies ++= Seq(
  "joda-time" % "joda-time" % "2.9.3",
  "junit" % "junit" % "4.12" % "test",
  "com.novocode" % "junit-interface" % "0.11" % "test"
)

lazy val `timeywimey-core` = project

lazy val root = (project in file("."))
  .aggregate(`timeywimey-core`)
