addSbtPlugin("tv.cntt" % "xitrum-plugin" % "1.3")

resolvers += Resolver.url(
  "xsbt-scalate-generator",
  new URL("http://scalasbt.artifactoryonline.com/scalasbt/sbt-plugin-releases/")
)(Resolver.ivyStylePatterns)

addSbtPlugin("com.mojolly.scalate" % "xsbt-scalate-generator" % "0.2.1")

addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "2.1.0")
