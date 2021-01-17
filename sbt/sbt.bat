@echo off

set SCRIPT_DIR=%~dp0

java -Xms256m -Xmx512m -Xss1m -XX:MaxMetaspaceSize=384m -XX:+CMSClassUnloadingEnabled -jar "%SCRIPT_DIR%sbt-launch-1.4.5.jar" %*
