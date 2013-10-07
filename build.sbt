// Import xsbt-scalate-generator keys; this must be at top of build.sbt, or SBT will complain
import ScalateKeys._

organization := "tv.cntt"

name         := "xitrum-new"

version      := "1.0-SNAPSHOT"

scalaVersion := "2.10.3"

scalacOptions ++= Seq(
  "-deprecation",
  "-feature",
  "-unchecked"
)

// Most Scala projects are published to Sonatype, but Sonatype is not default
// and it takes several hours to sync from Sonatype to Maven Central
resolvers += "SonatypeReleases" at "http://oss.sonatype.org/content/repositories/releases/"

libraryDependencies += "tv.cntt" %% "xitrum" % "2.10"

// Xitrum uses SLF4J, an implementation of SLF4J is needed
libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.0.13"

// By default, version 2.10.0 of the libs below is used!!! ---------------------

libraryDependencies <+= scalaVersion { sv =>
  "org.scala-lang" % "scala-compiler" % sv
}

libraryDependencies <+= scalaVersion { sv =>
  "org.scala-lang" % "scala-reflect" % sv
}

libraryDependencies <+= scalaVersion { sv =>
  "org.scala-lang" % "scalap" % sv
}

// xgettext i18n translation key string extractor is a compiler plugin ---------

autoCompilerPlugins := true

addCompilerPlugin("tv.cntt" %% "xgettext" % "1.0")

scalacOptions += "-P:xgettext:xitrum.I18n"

// xitrum.imperatively uses Scala continuation, also a compiler plugin ---------

// https://groups.google.com/forum/?fromgroups#!topic/simple-build-tool/ReZvT14noxU
libraryDependencies <+= scalaVersion { sv =>
  compilerPlugin("org.scala-lang.plugins" % "continuations" % sv)
}

scalacOptions += "-P:continuations:enable"

// Template engine for Xitrum --------------------------------------------------

libraryDependencies += "tv.cntt" %% "xitrum-scalate" % "1.2"

// Precompile Scalate
seq(scalateSettings:_*)

scalateTemplateConfig in Compile := Seq(TemplateConfig(
  file("src") / "main" / "scalate",  // See config/scalate.conf
  Seq(),
  Seq(Binding("helper", "xitrum.Action", true))
))

// Put config directory in classpath for easier development --------------------

// For "sbt console"
unmanagedClasspath in Compile <+= (baseDirectory) map { bd => Attributed.blank(bd / "config") }

// For "sbt run"
unmanagedClasspath in Runtime <+= (baseDirectory) map { bd => Attributed.blank(bd / "config") }
