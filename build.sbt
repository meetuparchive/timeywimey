lazy val `timeywimey-core` = project

import org.scoverage.coveralls.Imports.CoverallsKeys._

enablePlugins(CommonSettingsPlugin)
enablePlugins(CoverallsWrapper)

autoScalaLibrary := false

name := "timeywimey"

resolvers += "softprops-maven" at "http://dl.bintray.com/content/softprops/maven"

bintrayOrganization in ThisBuild := Some("meetup")

licenses in ThisBuild += ("MIT", url("http://opensource.org/licenses/MIT"))