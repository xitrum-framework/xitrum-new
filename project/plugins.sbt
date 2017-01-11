// Run sbt eclipse to create Eclipse project file
addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "2.3.0")

// Run sbt xitrum-package to prepare for deploying to production environment
addSbtPlugin("tv.cntt" % "xitrum-package" % "1.9")

// For precompiling Scalate templates in the compile phase of SBT
addSbtPlugin("org.scalatra.scalate" % "sbt-scalate-precompiler" % "1.8.0.1")
