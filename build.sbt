name := "young-weixin"

version := "1.0-SNAPSHOT"

libraryDependencies ++= {
  val mysql_driver_version = "5.1.27"
  val http_client_version = "4.4.1"
  val xstream_version = "1.4.8"
  val jackson_version = "1.9.13"
  Seq(
    jdbc,
    anorm,
    cache,
    "mysql" % "mysql-connector-java" % mysql_driver_version,
    "org.apache.httpcomponents" % "httpclient" % http_client_version,
    "org.apache.httpcomponents" % "httpcore" % http_client_version,
    "org.apache.httpcomponents" % "httpmime" % http_client_version,
    "com.thoughtworks.xstream" % "xstream" % xstream_version,
    "org.codehaus.jackson" % "jackson-mapper-asl" % jackson_version,
    "org.codehaus.jackson" % "jackson-core-asl" % jackson_version,
    "commons-io" % "commons-io" % "2.4",
    "org.jdom" % "jdom" % "2.0.2",
    "commons-codec" % "commons-codec" % "1.10",
    "com.typesafe.play" %% "play-slick" % "1.1.1"
  )
}

play.Project.playScalaSettings
