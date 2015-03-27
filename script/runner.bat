@echo off

for /f "tokens=3" %%g in ('java -version 2^>^&1 ^| findstr /i "version"') do (
    set JAVA_VERSION=%%g
)

set JAVA_VERSION=%JAVA_VERSION:"=%

for /f "delims=. tokens=1-3" %%v in ("%JAVA_VERSION%") do (
    set MAJOR=%%v
    set MINOR=%%w
    set BUILD=%%x

    set META_SIZE=-XX:MaxMetaspaceSize=384m
    if %MINOR% LSS 8 (
      set META_SIZE=-XX:MaxPermSize=384m
    )
)

rem You may need to customize memory config below to optimize for your environment.
rem To display time when the application is stopped for GC:
rem -XX:+PrintGCTimeStamps -XX:+PrintGCApplicationStoppedTime
set JAVA_OPTS=-Xmx1024m -Xms256m %META_SIZE% -XX:+HeapDumpOnOutOfMemoryError -XX:+AggressiveOpts -XX:+OptimizeStringConcat -XX:+UseFastAccessorMethods -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+CMSParallelRemarkEnabled -XX:+CMSClassUnloadingEnabled -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1 -XX:CMSInitiatingOccupancyFraction=75 -XX:+UseCMSInitiatingOccupancyOnly -Djava.awt.headless=true -server -Dxitrum.mode=production

set ROOT_DIR=%~dp0..
cd "%$ROOT_DIR%"

rem Include ROOT_DIR to find this pid easier later, when
rem starting multiple processes from different directories
set CLASS_PATH="%ROOT_DIR%\lib\*;config"

java %JAVA_OPTS% -cp %CLASS_PATH% %*
