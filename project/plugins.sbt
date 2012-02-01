addSbtPlugin("tv.cntt" % "xitrum-plugin" % "1.3")

libraryDependencies <+= sbtVersion(v => "com.mojolly.scalate" %% "xsbt-scalate-generator" % (v + "-0.1.5"))
