name := "Search"

version := "0.1"

scalaVersion := "2.13.6"

resolvers += "Artima Maven Repository" at "https://repo.artima.com/releases"

libraryDependencies ++= List(
  "org.scalactic" %% "scalactic" % "3.2.9",
  "org.scalatest" %% "scalatest" % "3.2.9" % "test"
)