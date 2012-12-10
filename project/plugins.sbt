// sbt/sbt xitrum-package
addSbtPlugin("tv.cntt" % "xitrum-plugin" % "1.3")

// For Xitrum to compile Scalate templates on sbt/sbt compile, run etc.
resolvers += Resolver.url(
  "xsbt-scalate-generator",
  url("http://scalasbt.artifactoryonline.com/scalasbt/sbt-plugin-releases/")
)(Resolver.ivyStylePatterns)

addSbtPlugin("com.mojolly.scalate" % "xsbt-scalate-generator" % "0.2.1")

// sbt/sbt eclipse
addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "2.1.0")
