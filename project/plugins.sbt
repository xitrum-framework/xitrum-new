// Run sbt/sbt eclipse to create Eclipse project file
addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "2.1.2")

// For compiling Scalate templates in the compile phase of SBT
addSbtPlugin("com.mojolly.scalate" % "xsbt-scalate-generator" % "0.4.2")

// Run sbt/sbt xitrum-package to prepare for deploying to production environment
addSbtPlugin("tv.cntt" % "xitrum-plugin" % "1.4")

