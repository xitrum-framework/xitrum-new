set SCRIPT_DIR=%~dp0
java -javaagent:"%SCRIPT_DIR%agent7-1.0.jar" -Xms256M -Xmx512M -Xss1M -XX:+CMSClassUnloadingEnabled -XX:MaxPermSize=384M -jar "%SCRIPT_DIR%sbt-launch-0.13.5.jar" %*
