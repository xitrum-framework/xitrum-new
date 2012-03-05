// import must be at top of build.sbt, or SBT will complain
import com.mojolly.scalate.ScalatePlugin._

organization := "tv.cntt"

name         := "xitrum-quickstart"

version      := "1.0-SNAPSHOT"

scalaVersion := "2.9.1"

scalacOptions ++= Seq(
  "-deprecation",
  "-unchecked"
)

// Remove this when Netty 4 is released (this must be put before Xitrum below)
libraryDependencies += "io.netty" % "netty" % "4.0.0.Alpha1-SNAPSHOT" from "http://cloud.github.com/downloads/ngocdaothanh/xitrum/netty-4.0.0.Alpha1-SNAPSHOT.jar"

// Xitrum uses Jerkson: https://github.com/codahale/jerkson
resolvers += "repo.codahale.com" at "http://repo.codahale.com"

// An implementation of SLF4J must be provided for Xitrum
libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.0.0"

libraryDependencies += "tv.cntt" %% "xitrum" % "1.8.4"

// xgettext i18n translation key string extractor is a compiler plugin ---------

autoCompilerPlugins := true

addCompilerPlugin("tv.cntt" %% "xitrum-xgettext" % "1.1")

// xitrum.imperatively uses Scala continuation, also a compiler plugin ---------

addCompilerPlugin("org.scala-lang.plugins" % "continuations" % "2.9.1")

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
