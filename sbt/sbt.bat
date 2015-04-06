@echo off

set SCRIPT_DIR=%~dp0

for /f "tokens=3" %%g in ('java -version 2^>^&1 ^| findstr /i "version"') do (
    set JAVA_VERSION=%%g
)

set JAVA_VERSION=%JAVA_VERSION:"=%

for /f "delims=. tokens=1-3" %%v in ("%JAVA_VERSION%") do (
    set MAJOR=%%v
    set MINOR=%%w
    set BUILD=%%x

    set META_SIZE=-XX:MaxMetaspaceSize=384M
    if %MINOR% LSS 8 (
      set META_SIZE=-XX:MaxPermSize=384M
    )
)

java -javaagent:"%SCRIPT_DIR%agent7-1.0.jar" -Xms256M -Xmx512M -Xss1M -XX:+CMSClassUnloadingEnabled %META_SIZE% -jar "%SCRIPT_DIR%sbt-launch-0.13.8.jar" %*
