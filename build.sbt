// import must be at top of build.sbt, or SBT will complain
import ScalateKeys._

organization := "tv.cntt"

name         := "xitrum-new"

version      := "1.0-SNAPSHOT"

scalaVersion := "2.9.2"

scalacOptions ++= Seq(
  "-deprecation",
  "-unchecked"
)

// Most Scala projects are published to Sonatype, but Sonatype is not default
// and it takes several hours to sync from Sonatype to Maven Central
resolvers += "SonatypeReleases" at "http://oss.sonatype.org/content/repositories/releases/"

libraryDependencies += "tv.cntt" %% "xitrum" % "1.9.10"

// Xitrum uses Akka
resolvers += "Typesafe" at "http://repo.typesafe.com/typesafe/releases/"

// Xitrum uses Jerkson
resolvers += "repo.codahale.com" at "http://repo.codahale.com"

// Xitrum uses SLF4J, an implementation of SLF4J is needed
libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.0.7"

// xgettext i18n translation key string extractor is a compiler plugin ---------

autoCompilerPlugins := true

addCompilerPlugin("tv.cntt" %% "xitrum-xgettext" % "1.1")

// xitrum.imperatively uses Scala continuation, also a compiler plugin ---------

addCompilerPlugin("org.scala-lang.plugins" % "continuations" % "2.9.2")

scalacOptions += "-P:continuations:enable"

// Precompile Scalate ----------------------------------------------------------

seq(scalateSettings:_*)

scalateTemplateDirectory in Compile <<= (baseDirectory) { _ / "src/main/view" }

scalateBindings += Binding("helper", "xitrum.Controller", true)

// Put config directory in classpath for easier development --------------------

// For "sbt console"
unmanagedClasspath in Compile <+= (baseDirectory) map { bd => Attributed.blank(bd / "config") }

// For "sbt run"
unmanagedClasspath in Runtime <+= (baseDirectory) map { bd => Attributed.blank(bd / "config") }
