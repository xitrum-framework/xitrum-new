// Run sbt eclipse to create Eclipse project file
addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "5.2.4")

// Run sbt xitrum-package to prepare for deploying to production environment
addSbtPlugin("tv.cntt" % "xitrum-package" % "2.0.0")

// For precompiling Scalate templates in the compile phase of SBT
addSbtPlugin("org.scalatra.scalate" % "sbt-scalate-precompiler" % "1.9.6.0")
