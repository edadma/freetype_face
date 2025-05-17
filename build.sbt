name := "freetype_face"
ThisBuild / licenses += "ISC"      -> url("https://opensource.org/licenses/ISC")
ThisBuild / versionScheme          := Some("semver-spec")
ThisBuild / evictionErrorLevel     := Level.Warn
ThisBuild / scalaVersion           := "3.7.0"
ThisBuild / organization           := "io.github.edadma"
ThisBuild / organizationName       := "edadma"
ThisBuild / organizationHomepage   := Some(url("https://github.com/edadma"))
ThisBuild / version                := "0.0.21"
ThisBuild / sonatypeCredentialHost := "s01.oss.sonatype.org"
ThisBuild / sonatypeRepository     := "https://s01.oss.sonatype.org/service/local"

ThisBuild / publishConfiguration := publishConfiguration.value.withOverwrite(true).withChecksums(Vector.empty)
ThisBuild / resolvers ++= Seq(
  Resolver.mavenLocal,
)
ThisBuild / resolvers ++= Resolver.sonatypeOssRepos("snapshots") ++ Resolver.sonatypeOssRepos("releases")

ThisBuild / sonatypeProfileName := "io.github.edadma"

ThisBuild / scmInfo := Some(
  ScmInfo(
    url("https://github.com/edadma/freetype_face"),
    "scm:git@github.com:edadma/freetype_face.git",
  ),
)
ThisBuild / developers := List(
  Developer(
    id = "edadma",
    name = "Edward A. Maxedon, Sr.",
    email = "edadma@gmail.com",
    url = url("https://github.com/edadma"),
  ),
)

ThisBuild / homepage := Some(url("https://github.com/edadma/freetype_face"))

ThisBuild / pomIncludeRepository := { _ => false }
ThisBuild / publishTo := {
  val nexus = "https://s01.oss.sonatype.org/"
  if (isSnapshot.value) Some("snapshots" at nexus + "content/repositories/snapshots")
  else Some("releases" at nexus + "service/local/staging/deploy/maven2")
}
ThisBuild / publishMavenStyle := true

lazy val freetype_face = project
  .in(file("."))
  .settings(
    name := "freetype_face",
    scalacOptions ++=
      Seq(
        "-deprecation",
        "-feature",
        "-unchecked",
        "-Xfatal-warnings",
      ),
    libraryDependencies ++= Seq(
      "org.scalatest"    %%% "scalatest"      % "3.2.19" % "test",
      "com.github.scopt" %%% "scopt"          % "4.1.0",
      "com.lihaoyi"      %%% "pprint"         % "0.9.0"  % "test",
      "dev.zio"          %%% "zio-json"       % "0.7.42" % "test",
      "io.github.edadma" %%% "cross-platform" % "0.0.3" /*% "test"*/,
      "io.github.edadma" %%% "logger"         % "0.0.11",
      "io.github.edadma" %%% "dllist"         % "0.0.6",
      "io.github.edadma" %%% "recognizer"     % "0.0.2",
    ),
    publishMavenStyle      := true,
    Test / publishArtifact := false,
    licenses += "ISC"      -> url("https://opensource.org/licenses/ISC"),
    libraryDependencies += "io.github.cquiroz" %%% "scala-java-time" % "2.6.0",
    libraryDependencies += "org.scala-js"       %% "scalajs-stubs"   % "1.1.0" % "provided",

//lazy val root = project
//  .in(file("."))
//  .aggregate(markdown.js, markdown.jvm, markdown.native)
//  .settings(
//    name                := "markdown",
//    publish / skip      := true,
//    publishLocal / skip := true,
//  )
