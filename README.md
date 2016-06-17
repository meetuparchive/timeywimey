# Timeywimey

## Description

Timeywimey is a collection of libraries providing conversion utilities for JodaTime, Legacy `java.util.Date`, and Java 8 `java.time` classes.

`timeywimey-core` provides Java static methods for the conversion logic usable in both Java 8 and Scala.

`timeywimey-scala` includes Scala implicits to provide syntactic sugars `.asJava` and `.asJoda`.

## Project structure
```
.-+-timeywimey-core
  |  +-src
  |  |  +-main
  |  |  |  +-java
  |  |  |     +-com.meetup.timeywimey
  |  |  |        +-JodaConverters.java
  |  |  |        +-LegacyConverters.java
  |  |  +-test
  |  |     +-java
  |  |        +-com.meetup.timeywimey
  |  |           +-JodaConvertersTest.java
  |  |           +-LegacyConvertersTest.java
  |  +-build.sbt
  |
  +-timeywimey-scala
  |  +-src
  |  |  +-main
  |  |  |  +-scala
  |  |  |     +-com.meetup.timeywimey
  |  |  |        +-JodaConverterImplicits.scala
  |  |  |        +-LegacyConverterImplicits.scala
  |  |  +-test
  |  |    +-scala
  |  |        +-com.meetup.timeywimey
  |  |           +-JodaConverterImplicitsTest.scala
  |  |           +-LegacyConverterImplicitsTest.scala
  |  +-build.sbt
  |
  +-project
  |  +-Build.scala
  |  +-build.properties
  |  +-plugins.sbt
  |
  +-.gitignore
  +-Makefile
  +-README.md
  +-build.sbt
```

## Build

Use sbt 0.13+ for testing (Scalatest) and building.

## License

Timeywimey is released under the MIT License (https://opensource.org/licenses/MIT)