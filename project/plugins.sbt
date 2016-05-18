credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")
resolvers += "Nexus" at "https://nexus.blt.meetup.com/content/repositories/releases"

addSbtPlugin("com.meetup" % "sbt-plugins" % "16.0.0")

addSbtPlugin("com.eed3si9n" % "sbt-dirty-money" % "0.1.0")
