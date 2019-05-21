  name := """zookeeper-java"""

  version := "1.0-Snapshot"

  scalaVersion := "2.11.8"
  
  libraryDependencies ++= Seq(
  "args4j" % "args4j" % "2.33",
	  "org.apache.zookeeper" % "zookeeper" % "3.4.13"
  )

resolvers += "elasticsearch-releases" at "https://artifacts.elastic.co/maven"
  