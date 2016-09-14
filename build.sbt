name := "Lift 2.6 starter template"

version := "0.0.4"

organization := "net.liftweb"

scalaVersion := "2.11.7"

resolvers ++= Seq("snapshots"     at "https://oss.sonatype.org/content/repositories/snapshots",
                  "staging"       at "https://oss.sonatype.org/content/repositories/staging",
                  "releases"      at "https://oss.sonatype.org/content/repositories/releases"
                 )

//seq(webSettings :_*)

unmanagedResourceDirectories in Test <+= (baseDirectory) { _ / "src/main/webapp" }

scalacOptions ++= Seq("-deprecation", "-unchecked")

libraryDependencies ++= {
  val liftVersion = "2.6.2"
  val jettyVersion = "9.3.2.v20150730"
  Seq(
    "net.liftweb"            %% "lift-webkit"            % liftVersion  % "compile",
    "net.liftweb"            %% "lift-mapper"            % liftVersion  % "compile",
    "net.liftmodules"        %% "lift-jquery-module_2.6" % "2.8",
    "org.eclipse.jetty"      % "jetty-webapp"            % jettyVersion,
    "org.eclipse.jetty"      % "jetty-plus"              % jettyVersion  % "container", // For Jetty Config
    "com.geishatokyo.jetty"  %  "jetty-nosql-memcached"  % "0.6.0-SNAPSHOT",
    "org.wvlet"              %% "wvlet-log"              % "1.0",
    "org.slf4j"              % "slf4j-jdk14"             % "1.7.5",
    "org.specs2"             %% "specs2-core"            % "3.6.4"       % "test",
    "com.h2database"         % "h2"                      % "1.4.187"
  )
}

scalacOptions in Test ++= Seq("-Yrangepos")

enablePlugins(JettyPlugin)

containerArgs := Seq(
  "--path", "lift-jsnlog",
  "--port", "8088")
