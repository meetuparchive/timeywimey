name := "timeywimey-scala"

organization := "com.meetup"

version := "0.1.0"

scalaVersion := "2.11.8"

description := "Converters between JodaTime and Java 8 time classes, plus some legacy java.util time classes utility."

publishMavenStyle := true

libraryDependencies ++= Seq(
  "joda-time" % "joda-time" % "2.9.3"
)

lazy val `timeywimey-scala` = project

lazy val root = (project in file("."))
  .aggregate(`timeywimey-scala`)
