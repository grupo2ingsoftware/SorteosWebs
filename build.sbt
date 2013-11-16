name := "sorteosWeb"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
cache,
"mysql" % "mysql-connector-java" % "5.1.13",
javaJpa,
"org.hibernate" % "hibernate-entitymanager" % "4.2.7.Final"
)     

play.Project.playJavaSettings
