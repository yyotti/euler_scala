name := """euler_scala"""

version := "1.0"

scalaVersion := "2.11.7"

// Change this to another test framework if you prefer
libraryDependencies += "org.specs2" %% "specs2-core" % "3.6.4" % "test"

// Uncomment to use Akka
//libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.3.11"

scalacOptions ++= Seq("-deprecation", "-feature")
