organization := "tv.cntt"
name         := "xitrum-new"
version      := "1.0-SNAPSHOT"

scalaVersion := "2.11.8"
scalacOptions ++= Seq("-deprecation", "-feature", "-unchecked")

// Xitrum requires Java 8
javacOptions ++= Seq("-source", "1.8", "-target", "1.8")

//------------------------------------------------------------------------------

libraryDependencies += "tv.cntt" %% "xitrum" % "3.28.1"

// Xitrum uses SLF4J, an implementation of SLF4J is needed
libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.1.7"

// For writing condition in logback.xml
libraryDependencies += "org.codehaus.janino" % "janino" % "3.0.6"

libraryDependencies += "org.webjars.bower" % "bootstrap-css" % "3.3.6"

// Scalate template engine config for Xitrum -----------------------------------

libraryDependencies += "tv.cntt" %% "xitrum-scalate" % "2.7.0"

// Precompile Scalate templates
Seq(scalateSettings:_*)
ScalateKeys.scalateTemplateConfig in Compile := Seq(TemplateConfig(
  baseDirectory.value / "src" / "main" / "scalate",
  Seq(),
  Seq(Binding("helper", "xitrum.Action", importMembers = true))
))

// xgettext i18n translation key string extractor is a compiler plugin ---------

autoCompilerPlugins := true
addCompilerPlugin("tv.cntt" %% "xgettext" % "1.3")
scalacOptions += "-P:xgettext:xitrum.I18n"

// Put config directory in classpath for easier development --------------------

// For "sbt console"
unmanagedClasspath in Compile <+= baseDirectory map { bd => Attributed.blank(bd / "config") }

// For "sbt run"
unmanagedClasspath in Runtime <+= baseDirectory map { bd => Attributed.blank(bd / "config") }

// Copy these to target/xitrum when sbt xitrum-package is run
XitrumPackage.copy("config", "public", "script")
