lazy val `timeywimey-core` = project

import org.scoverage.coveralls.Imports.CoverallsKeys._

enablePlugins(CommonSettingsPlugin)
enablePlugins(NexusPlugin)
enablePlugins(CoverallsWrapper)

autoScalaLibrary := false

name := "timeywimey"

resolvers += "softprops-maven" at "http://dl.bintray.com/content/softprops/maven"

coverallsServiceName := Some("travis-pro")