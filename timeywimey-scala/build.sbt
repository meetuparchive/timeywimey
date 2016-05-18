enablePlugins(NexusPlugin)

name := "timeywimey-scala"

organization := "com.meetup"

version := "0.1.1"

scalaVersion := "2.11.7"

description := "Converters between JodaTime and Java 8 time classes, plus some legacy java.util time classes utility."

publishMavenStyle := true

libraryDependencies ++= Seq(
  "joda-time" % "joda-time" % "2.9.3"
)
