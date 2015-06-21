name := "Exercises"

version := "1.0"

scalaVersion := "2.11.6"

libraryDependencies += "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test"

libraryDependencies += "org.apache.spark" %% "spark-core" % "1.4.0"

libraryDependencies += "com.datastax.spark" % "spark-cassandra-connector_2.11" % "1.4.0-M1"
