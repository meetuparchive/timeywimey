enablePlugins(CommonSettingsPlugin)

name := "timeywimey-scala"

description := "Converters between JodaTime and Java 8 time classes, plus some legacy java.util time classes utility."

libraryDependencies ++= Seq(
  "joda-time" % "joda-time" % "2.9.3"
)
