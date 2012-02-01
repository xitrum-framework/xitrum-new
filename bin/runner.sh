#!/bin/sh

# You may need to customize memory config below to optimize for your environment
JAVA_OPTS='-server -Xms256m -Xmx1024m -XX:MaxPermSize=128m -XX:+UseParallelGC -Djava.awt.headless=true -Dxitrum.mode=production'

# Quote because path may contain spaces
if [ -h $0 ]
then
  ROOT_DIR="$(cd "$(dirname "$(readlink -n "$0")")/.." && pwd)"
else
  ROOT_DIR="$(cd "$(dirname $0)/.." && pwd)"
fi
cd "$ROOT_DIR"

# Put slf4j-api to the front to avoid error (not always occurs):
# The requested version 1.6 by your slf4j binding is not compatible with [1.5.5, 1.5.6, 1.5.7, 1.5.8]
#
# Include ROOT_DIR to do "ps aux | grep java" to get pid easier when
# starting multiple processes from different directories
CLASS_PATH="$ROOT_DIR/lib/slf4j-api-1.6.4.jar:lib/*:config"

# Use exec to be compatible with daemontools:
# http://cr.yp.to/daemontools.html
exec java $JAVA_OPTS -cp $CLASS_PATH "$@"
