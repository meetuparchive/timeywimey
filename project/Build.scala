import sbt._
import Keys._
/*
object TimeywimeyBuild extends Build {
  lazy val root = Project(id = "timeywimey", base = file(".")) aggregate(core, scala) dependsOn(core, scala)

  lazy val core = Project(id = "timeywimey-core", base = file("timeywimey-core"))

  lazy val scala = Project(id = "timeywimey-scala", base = file("timeywimey-scala")) dependsOn(core)
}
*/