import sbt._
import Keys._

object TimeywimeyBuild extends Build {
  lazy val root = Project(id = "timeywimey", base = file(".")) aggregate(`timeywimey-core`, `timeywimey-scala`) dependsOn(`timeywimey-core`, `timeywimey-scala`)

  lazy val `timeywimey-core` = Project(id = "timeywimey-core", base = file("timeywimey-core"))

  lazy val `timeywimey-scala` = Project(id = "timeywimey-scala", base = file("timeywimey-scala")) dependsOn `timeywimey-core`
}
