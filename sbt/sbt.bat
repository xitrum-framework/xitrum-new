set SCRIPT_DIR=%~dp0
java -Xms256M -Xmx512M -Xss1M -XX:+CMSClassUnloadingEnabled -XX:MaxPermSize=384M -jar "%SCRIPT_DIR%sbt-launch-0.13.2.jar" %*
